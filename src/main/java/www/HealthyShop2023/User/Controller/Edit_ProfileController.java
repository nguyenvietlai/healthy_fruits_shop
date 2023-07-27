package www.HealthyShop2023.User.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import www.HealthyShop2023.DAO.accountDAO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Service.ParamService;
import www.HealthyShop2023.Service.sessionServices;
import www.HealthyShop2023.Utils.constant;

@Controller
public class Edit_ProfileController {
	@Autowired
	accountDAO accountDao;
	@Autowired
	public sessionServices session;
	@Autowired
	public ParamService paramservice;
	@GetMapping("/profile.php")
	public String profile_display(Model model) {
		Account acc = new Account();
		model.addAttribute("account", acc);
		
		return "user/viewprofile";   
	}
	 
	@PostMapping("/profile/update")
	public String profileUpdate(Model model,@RequestParam("image") MultipartFile file,@ModelAttribute("account") Account account) {
		
		Account existingAccount = accountDao.findByUsername(account.getUsername());
		

		
		if (existingAccount == null  && !existingAccount.getId().equals(account.getId())) {
			model.addAttribute("mess", "loiiiiiiiiiiiiiiiiiiiiiiiiii");  
			return "redirect:/profile.php"; 
		}
		else {
			paramservice.removeFile(existingAccount.getPhoto(), "/templates/assets/images/");
			String filephoto = paramservice.save(file, "/templates/assets/images/");
			existingAccount.setId(account.getId());
			existingAccount.setActivated(account.getActivated());
			existingAccount.setAdmin(account.getAdmin());
			existingAccount.setEmail(account.getEmail());
			existingAccount.setFullname(account.getFullname());
			existingAccount.setUsername(account.getUsername());
			
			existingAccount.setPhoto(filephoto);
//			   
			try {
				
			    accountDao.save(existingAccount);
			    existingAccount.setPassword(null);
			    session.set(constant.CURRENT_USER, existingAccount);
			    
			    System.out.println("Lưu dữ liệu thành công");
			} catch (Exception e) {
			  
			    System.out.println("Lỗi khi lưu dữ liệu: " + e.getMessage());
			    e.printStackTrace();
			    model.addAttribute("mess", "okkkkkkkkkkkkkkkkkkkkkkkkkk"); 
			}
//			
//			
			 return "redirect:/profile.php";
		}
		
		
	}
	
	

}