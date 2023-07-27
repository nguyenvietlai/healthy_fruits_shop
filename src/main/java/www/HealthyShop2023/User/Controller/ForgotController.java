package www.HealthyShop2023.User.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.HealthyShop2023.DAO.accountDAO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.MailInfo;
import www.HealthyShop2023.Service.MailerService;
import www.HealthyShop2023.Utils.JWT;

@Controller
public class ForgotController {
	@Autowired
	private accountDAO accountDao;
	
	@Autowired
	private MailerService mailer;
	
	
	@GetMapping("/forgot.php")
	public String home(Model model) {
		return "user/forgot";
	}
	@PostMapping("/forgot.php")
	public String recapchaEmail(Model model , @RequestParam("email") String email) {
		Account acc = accountDao.findByEmail(email);
		if(acc == null) {
			model.addAttribute("msg", "This email doesn't exist !");
		}else {
			model.addAttribute("msg", "Please check your email !");
			Map<String, Object> yourAccount = new HashMap<>();
			yourAccount.put("email",email);
			String token = JWT.createJWT(yourAccount);
			try {
				mailer.send(new MailInfo(email,"Xac nhan mk","Click here: http://localhost:8080/rersetpass.php?token="+token));
			} catch (Exception e) {
				return "redirect:/forgot.php";
			}
		}
		return "user/forgot";
	}
}
