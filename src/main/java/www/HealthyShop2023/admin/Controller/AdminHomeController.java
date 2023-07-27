package www.HealthyShop2023.admin.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import www.HealthyShop2023.Model.Product;



@Controller
public class AdminHomeController {
	
	@GetMapping("/admin/home")
	public String displayHome(Model model	) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "admin/home";
	}


}
