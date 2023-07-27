package www.HealthyShop2023.User.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import www.HealthyShop2023.DAO.categoriesDAO;
import www.HealthyShop2023.DAO.productDAO;
import www.HealthyShop2023.DTO.ProductDTO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.CartSession;
import www.HealthyShop2023.Model.Category;
import www.HealthyShop2023.Model.Product;
import www.HealthyShop2023.Service.ShoppingCartServiceImpl;
import www.HealthyShop2023.Utils.ManagerUser;
import www.HealthyShop2023.Utils.import_fileExcel;
import www.HealthyShop2023.collections.SortByPrice;

@Controller
public class ProductController {
	@Autowired
	ShoppingCartServiceImpl cart;

	@Autowired
	private productDAO productdao;
	
	@Autowired
	private categoriesDAO catedao;

	@GetMapping("/products.php")
	public String products(Model model) {
		List<Product> list = productdao.findAll();

		model.addAttribute("products", list);
		return "user/products";
	}

	@ResponseBody
	@GetMapping("/getproducts.php")
	public List<Product> getproducts(@RequestParam(required = false) Boolean ascending,
			@RequestParam(required = false) Boolean decending) {
		List<Product> list = productdao.findAll();

		if (ascending != null && ascending == true) {
			list.sort(new SortByPrice());
		} else if (decending != null && decending == true) {
			list.sort(new SortByPrice().reversed());
		}

		return list;
	}

	public List<Product> loadProducts() {

		try {
			return import_fileExcel.importByExecl(new FileInputStream(new File("D:\\Java5\\data.xlsx")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@ModelAttribute("current_size")
	public Integer shoppingcart() {
		if (cart.getCount() == 0) {
			return 0;
		}
		return cart.getCount();
	}

	@ModelAttribute("myCarts")
	public Collection<ProductDTO> getItems() {
		return cart.getItems();
	}

	@GetMapping("/show-products-discount")
	public String showProductsDiscount(Model model, @RequestParam(required = false) String status) {
		if (status.equals("ten")) {
			List<Product> list = productdao.findByDiscountAfterOrderByPrice();
			model.addAttribute("products", list);
			model.addAttribute("tenz", status);
			return "user/products";
		}
		return "redirect:/products.php";
	}

	@GetMapping("/show-products-by-price")
	public String showProductsByPrice(Model model, @RequestParam(required = true) Double min,
			@RequestParam(required = true) Double max) {
		try {
			List<Product> list = productdao.findByPriceBetween(min, max);
			model.addAttribute("products", list);
			model.addAttribute("min", min);
			model.addAttribute("max", max);
		} catch (Exception e) {
			return "redirect:/products.php";
		}

		return "user/products";
	}
	
	@GetMapping("/show-products-by-cate")
	public String showProductsByCate(Model model, @RequestParam(required = true) Long category) {
		if(category!=null&&category != -1) {
			try {
				Category cate =new Category();
				cate.setId(category);
				List<Product> list = productdao.findByCategory(cate);
				model.addAttribute("products", list);
				model.addAttribute("cate", category);
			} catch (Exception e) {
				return "redirect:/products.php";
			}
		}else {
			return "redirect:/products.php";
		}

		return "user/products";
	}
	

	@ModelAttribute("categories")
		public List<Category> showCategories(){
			List<Category> list = catedao.findAll();
			return list;
		}
	
	
	
}
