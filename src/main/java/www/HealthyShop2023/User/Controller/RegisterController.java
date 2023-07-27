package www.HealthyShop2023.User.Controller;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.HealthyShop2023.DAO.accountDAO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.MailInfo;
import www.HealthyShop2023.Service.MailerService;
import www.HealthyShop2023.Service.ShoppingCartServiceImpl;
import www.HealthyShop2023.Utils.JWT;

@Controller
public class RegisterController {
	@Autowired
	private ShoppingCartServiceImpl cart;
	@Autowired
	private MailerService mailer;
	@Autowired
	private accountDAO accountDao;

	@GetMapping("/register.php")
	public String register_display(Model model) {
		model.addAttribute("register", new Account());
		return "user/register";
	}

	@GetMapping("/registerAccount")
	public String register(Model model, @RequestParam("token") String token) {
		if (!JWT.checkExp(token)) {
			model.addAttribute("msg", "Quá hạn thời gian , vui lòng yêu cầu lại");
		} else if (!JWT.checkSign(token)) {
			model.addAttribute("msg", "Error");
		} else {

			try {
				Account acc = new Account();
				acc.setEmail(getValue(token, "email"));
				acc.setFullname(getValue(token, "fullname"));
				acc.setPassword(getValue(token, "password"));
				acc.setUsername(getValue(token, "username"));
				acc.setPhoto(null);
				acc.setAdmin(false);
				acc.setActivated(true);
				accountDao.save(acc);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Register error");
				model.addAttribute("msg", "Tên hoặc email đã tồn tại");
			}
		}
		return "user/SuccessPage";
	}

	@PostMapping("/register.php")
	public String send(Model model, Account acc) {

			Map<String, Object> yourAccount = new HashMap<>();
			yourAccount.put("email", acc.getEmail());
			yourAccount.put("password", acc.getPassword());
			yourAccount.put("username", acc.getUsername());
			yourAccount.put("fullname", acc.getFullname());
			String token = JWT.createJWT(yourAccount);
			try {
				mailer.send(new MailInfo(acc.getEmail(), "Xac nhan mk",
						"Click here: http://localhost:8080/registerAccount?token=" + token));
			} catch (Exception e) {
				return "redirect:/register.php";
			}
			model.addAttribute("register", acc);
			model.addAttribute("success", true);

		return "user/register";
	}

	@ModelAttribute("current_size")
	public Integer shoppingcart() {
		if (cart.getCount() == 0) {
			return 0;
		}
		return cart.getCount();
	}

	private String getValue(String token, String name) {
		Object obj = JSONValue.parse(JWT.decodess(token));
		JSONObject jsonObject = (JSONObject) obj;
		return jsonObject.get(name).toString();

	}
}
