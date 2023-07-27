package www.HealthyShop2023.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.HealthyShop2023.DAO.accountDAO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Service.ShoppingCartServiceImpl;
import www.HealthyShop2023.Service.sessionServices;
import www.HealthyShop2023.Utils.constant;

@Controller	
public class LoginController {
	@Autowired
	ShoppingCartServiceImpl	cart;
	@Autowired
	public accountDAO accountDao;
	@Autowired
	public sessionServices session;
	@GetMapping("/login.php")
	public String login_display(Model model) {
		return "user/login";
	}
	@PostMapping("/login.php")
	public String login(Model model, @RequestParam String name, @RequestParam String pass) {
		Account account = accountDao.findByUsernameAndPassword(name, pass);
		if(account != null && !account.getAdmin()) {
			account.setPassword(null);
			session.set(constant.CURRENT_USER, account);
			return "user/home";
		}else if(account != null && account.getAdmin()){   
			 session.set(constant.CURRENT_USER, account);
			 return "admin/home";
		}else {
			return "redirect:/login.php";
		}
		
	}
	@GetMapping("/logout.php")
	public String logOut() {
		Account account = session.get(constant.CURRENT_USER);
		if(account!=null) {
			session.remove(constant.CURRENT_USER);
		}
		return "redirect:/home.php";
	}
	@ModelAttribute("current_size")
	public Integer shoppingcart() {
		if(cart.getCount() == 0) {
			return 0;
		}
		return cart.getCount();
	}
}
