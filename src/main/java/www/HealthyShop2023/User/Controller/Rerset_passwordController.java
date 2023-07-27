package www.HealthyShop2023.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.HealthyShop2023.DAO.accountDAO;
import www.HealthyShop2023.Model.Account;
@Controller
public class Rerset_passwordController {
	@Autowired
	accountDAO accountDao;
	@GetMapping("/rersetpass.php")
	public String Display_rersetpass(Model model,@RequestParam(required = false) String token) {
		
		String email = "user3@example.com";
		model.addAttribute("email", email);
		return "user/ResetPassword";
	}
	@PostMapping("/rersetpass/update")
	public String updatepass(Model model, @RequestParam("email") String email,@RequestParam("password") String pass,@RequestParam("confirmpass") String confirmpass) {
		if (!(pass.equals(confirmpass))) {
			model.addAttribute("mess", "Passwords or ConfirmPasswork is error !!");
			System.out.println("1111111111111");
			return "redirect:/rersetpass.php"; 
		} else {
			Account existingPass = accountDao.findByEmail(email);
			
			if (existingPass == null) {
				System.out.println("existingPass nulllllllllllllllllllllll");
				return "redirect:/rersetpass.php"; 
			}else {
				existingPass.setPassword(pass);
				try {
					accountDao.save(existingPass);
					
		
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		
		
		
		return "redirect:/rersetpass.php"; 
	}
}