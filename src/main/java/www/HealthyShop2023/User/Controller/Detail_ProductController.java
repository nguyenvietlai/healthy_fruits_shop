package www.HealthyShop2023.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import www.HealthyShop2023.DAO.productDAO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.Category;
import www.HealthyShop2023.Model.Product;
import www.HealthyShop2023.Service.ShoppingCartServiceImpl;
import www.HealthyShop2023.Service.sessionServices;
import www.HealthyShop2023.Utils.ManagerUser;

@Controller
public class Detail_ProductController {
	@Autowired
	private ShoppingCartServiceImpl	cart;
	@Autowired
	private productDAO productdao;

	
@GetMapping("/product/detailProduct/{id}")
public String detailProduct(Model model , @PathVariable("id") Long id) {
	Product pro  = productdao.findById(id).get();
	model.addAttribute("product_item", pro);
	Category cate =new Category();
	
	cate.setId(pro.getCategory().getId());
	List<Product> list = productdao.findByCategory(cate);
	model.addAttribute("products", list);
	return "user/detail_Product";
}
@ModelAttribute("current_size")
public Integer shoppingcart() {
	if(cart.getCount() == 0) {
		return 0;
	}
	return cart.getCount();
}


}
