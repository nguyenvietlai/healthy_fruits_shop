package www.HealthyShop2023.User.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import www.HealthyShop2023.DTO.ProductDTO;
import www.HealthyShop2023.Service.ShoppingCartServiceImpl;
@Controller
public class AboutUsController {
	@Autowired
	ShoppingCartServiceImpl	cart;
	@RequestMapping("/aboutus.php")
	public String home(Model model) {
		return "user/about-us";
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
		return cart.getItems();
	}
}
