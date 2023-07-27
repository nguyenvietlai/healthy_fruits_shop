package www.HealthyShop2023.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import www.HealthyShop2023.Model.MailInfo;
import www.HealthyShop2023.Service.MailerService;



@Controller
public class MailerController {

	@Autowired
	private MailerService mailer;
	
	@ResponseBody
	@RequestMapping("/mailer/send")
	public boolean send(Model model, MailInfo mailinfo) {
		try {
			mailer.queue(mailinfo.getTo(), mailinfo.getSubject(), mailinfo.getBody());
			model.addAttribute("mail", mailinfo);
		} catch (Exception e) {
			return false;
		}
		return true;
		
	}
}
