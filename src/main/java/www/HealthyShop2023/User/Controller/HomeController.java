package www.HealthyShop2023.User.Controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import www.HealthyShop2023.DAO.CartSessionDAO;
import www.HealthyShop2023.DAO.productDAO;
import www.HealthyShop2023.DTO.ProductDTO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.CartSession;
import www.HealthyShop2023.Model.Product;
import www.HealthyShop2023.Service.ShoppingCartServiceImpl;
import www.HealthyShop2023.Service.sessionServices;
import www.HealthyShop2023.Utils.ManagerUser;

@Controller
public class HomeController {
	@Autowired
	ShoppingCartServiceImpl	cart;
	@Autowired
	CartSessionDAO cartSSDao;
	
	@Autowired
	 sessionServices sessionservice;
	
	@Autowired
	private productDAO productdao;
	
	
	
	@RequestMapping("/home.php")
	public String home(Model model) {
		List<Product> list = productdao.findAll();
		model.addAttribute("products", list);
		return "user/home";
	}
	@ModelAttribute("current_size")
	public Integer shoppingcart() {
		if(cart.getCount() == 0) {
			return 0;
		}
		return cart.getCount();
	}
	
	@ModelAttribute("myCarts")
	public Collection<ProductDTO> getItems(){
		Account acc =ManagerUser.checklogin(sessionservice);
		if(acc != null) {
			List<CartSession> list = cartSSDao.findByAccount(acc);
			if(list != null && list.size() > 0) {
				cart.loadmycart(list);
			}
			 return cart.getItems();
		}
		return null;
	}
}
