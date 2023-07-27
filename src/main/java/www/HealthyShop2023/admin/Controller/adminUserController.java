package www.HealthyShop2023.admin.Controller;

import java.util.Optional;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.HealthyShop2023.DAO.accountDAO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.Product;
import www.HealthyShop2023.Service.sessionServices;

@Controller
@EnableTransactionManagement
public class adminUserController {
	@Autowired
	private accountDAO userdao;
	@Autowired 
	private sessionServices service;
	
	@GetMapping("/admin/users-manager")

	public String displayManagerProduct(Model model, @RequestParam("p") Optional<Integer> p) {
		
		Pageable pageable = PageRequest.of(p.orElse(0), 5); 
		model.addAttribute("users", userdao.findAll(pageable));
				model.addAttribute("user",  new Account());
			return "admin/user-manager";
	}
	
	
	@GetMapping("/admin/user/edit/{x}")

	public String productDelete(Model model , @PathVariable("x") Long id, @RequestParam("p") Optional<Integer> p) {
		Optional<Account> optionalAccount = userdao.findById(id);
		System.out.println(id);
		if (optionalAccount.isPresent()) {
		    Account account = optionalAccount.get();
		    System.out.println(account.getId());
		    account.setActivated(!account.getActivated());
		    //Nếu tạo @UniqueElements bên model sẽ bị lỗi
		    userdao.save(account);
		}
		return "forward:/admin/users-manager";
	}
	
	@RequestMapping("/admin/search")
	public String searchAndPage(Model model, 
			@RequestParam("keywords") Optional<String> kw,
			@RequestParam("p") Optional<Integer> p) {
		String kwords = kw.orElse(service.get("keywords"));
		System.out.println(kwords);
		service.set("keywords", kwords);
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		//Page<Product> page = dao.findByKeywords("%"+kwords+"%", pageable); //lab6.3
		Page<Account> users = userdao.findAllByNameLike("%"+kwords+"%", pageable); //lab6.5

		model.addAttribute("users", users);
		
		return "admin/user-manager";
	}
}
