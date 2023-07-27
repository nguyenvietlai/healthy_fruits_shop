package www.HealthyShop2023.admin.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import www.HealthyShop2023.DAO.categoriesDAO;
import www.HealthyShop2023.DAO.imagesOfProduct;
import www.HealthyShop2023.DAO.productDAO;
import www.HealthyShop2023.Model.Category;
import www.HealthyShop2023.Model.Imagesofproduct;
import www.HealthyShop2023.Model.Product;
import www.HealthyShop2023.Service.ParamService;

@Controller
public class adminProductController {
	@Autowired
	private productDAO productdao;
	@Autowired
	public categoriesDAO categorydao;
	@Autowired
	private ParamService paramService;
	@Autowired
	private imagesOfProduct productImage;

	@GetMapping("/admin/products-manager")
	@Cacheable("product")
	public String displayManagerProduct(Model model) {
		model.addAttribute("newForm", true);
		model.addAttribute("products", productdao.findAll());
		model.addAttribute("product", new Product());
		return "admin/product-manager";
	}

	
	@GetMapping("/admin/product/edit/{x}")
	@Cacheable("findProduct")
	public String productEdit(Model model, @PathVariable("x") Long id) {
		Product pro = productdao.findById(id).get();
		List<Imagesofproduct> images = pro.getImagesofproducts();

		model.addAttribute("product", pro);
		model.addAttribute("products", productdao.findAll());
		return "admin/product-manager";
	}

	
	@PostMapping("/admin/product/add")
	public String addNewElement(@RequestParam("files") MultipartFile[] files,
			@ModelAttribute("product") Product product) {
		String[] imagesName = imageName(files);
		product.setImage(imagesName[0]);
		product.setAvailable(true);
		product.setDiscount(0f);
		product.setCreatedate(new Date());

		productdao.save(product);

		insertImageOfProduct(imagesName, product);
		return "redirect:/admin/products-manager";
	}

	
	@Cacheable("categories")
	@ModelAttribute("categories")
	public List<Category> showCate() {
		return categorydao.findAll();
	}

	
	@GetMapping("/admin/product/delete/{x}")
	@Cacheable("findProduct")
	public String productDelete(Model model, @PathVariable("x") Long id) {
		Product product = new Product();
		product.setId(id);

		productdao.delete(product);
		return "redirect:/admin/products-manager";
	}

	
	@PostMapping("/admin/product/update")
	public String productUpdate(@ModelAttribute("product") Product product,
			@RequestParam(required = false, value = "oldImage") String[] oldImages,
			@RequestParam(required = false, value = "oldImageChange") String[] oldImageChange,
			@RequestParam(required = false, value = "files") MultipartFile[] files) {

		if (oldImages != null && oldImageChange != null && oldImageChange.length != oldImages.length) {
			String[] imageDeleted = findImageDeleted(oldImages, oldImageChange);
			for (int j = 0; j < imageDeleted.length; j++) {
				if (imageDeleted[j] != null) {
					productImage.deleteById(productImage.findByProductAndImage(product, imageDeleted[j]).getId());
				}
			}
		}
		if (files != null) {
			String[] imagesName = imageName(files);
			insertImageOfProduct(imagesName, product);
			product.setImage(imagesName[0]);
		}
		Product product2 = productdao.findById(product.getId()).get();
		if (product2 != null) {
			product2.update(product);
		}
		productdao.save(product2);
		return "redirect:/admin/product/edit/" + product.getId();
	}

	@PostMapping("admin/category/add")
	public String addCategory(@RequestParam("cate") String cateName) {
		Category cate = new Category();
		cate.setName(cateName);
		categorydao.save(cate);
		return "redirect:/admin/products-manager";
	}
	
	private String[] findImageDeleted(String[] oldImages, String[] oldImageChange) {
		for (int i = 0; i < oldImages.length; i++) {
			for (int j = 0; j < oldImageChange.length; j++) {
				if (oldImages[i].equals(oldImageChange[j])) {
					oldImages[i] = null;
					break;
				}
			}
		}
		return oldImages;
	}

	
	private void insertImageOfProduct(String[] imagesName, Product product) {
		for (int j = 0; j < imagesName.length; j++) {
			Imagesofproduct images = new Imagesofproduct();
			images.setImage(imagesName[j]);
			images.setProduct(product);
			Imagesofproduct imagesofproduct = productImage.findByProductAndImage(product, imagesName[j]);
			if (imagesofproduct == null) {
				productImage.save(images);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	
	private String[] imageName(MultipartFile[] files) {
		String[] imagesName = new String[files.length];
		int i = 0;
		for (MultipartFile file : files) {
			String fileName = paramService.save(file, "/templates/assets/images/");
			imagesName[i] = fileName;
			i++;
		}
		return imagesName;
	}
	

}
