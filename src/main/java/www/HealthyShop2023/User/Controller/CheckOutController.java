package www.HealthyShop2023.User.Controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import www.HealthyShop2023.DAO.CartSessionDAO;
import www.HealthyShop2023.DAO.orderDAO;
import www.HealthyShop2023.DAO.orderDetailDAO;
import www.HealthyShop2023.DTO.ProductDTO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.CartSession;
import www.HealthyShop2023.Model.Order;
import www.HealthyShop2023.Model.Orderdetail;
import www.HealthyShop2023.Service.ShoppingCartServiceImpl;
import www.HealthyShop2023.Service.sessionServices;
import www.HealthyShop2023.Utils.constant;
@Controller
public class CheckOutController {
	@Autowired
	private ShoppingCartServiceImpl	cart;
	@Autowired
	private CartSessionDAO cartssDao;
	@Autowired
	private orderDAO orderDao;
	@Autowired
	private orderDetailDAO orderdetailDAO;
	@Autowired
	private sessionServices session;
	@GetMapping("/checkout.php")
	public String home(Model model) {
		
		Account acc = session.get(constant.CURRENT_USER);
		List<CartSession> list = cartssDao.findByAccount(acc);
		int total =0;
		Double Sumprice = 0d;
		for (CartSession item : list) {
			total += item.getQuantity();
			Sumprice += (item.getQuantity() * item.getPrice());
			
		}
		model.addAttribute("SumItem", total);
		model.addAttribute("SumPrice",Sumprice );
		model.addAttribute("data", list); 
		return "user/check-out";
	}
	@PostMapping("/checkout/add")
	public String payment(Model model,@RequestParam("phone") String phone,@RequestParam("address") String address ) {
		
		Account acc = session.get(constant.CURRENT_USER);
		List<CartSession> list = cartssDao.findByAccount(acc);
		if (list != null && list.size() > 0) {
			Order oder = new Order();
			
			oder.setAddress(address);
			oder.setCreatedate(new Date());
			oder.setPhone_number(phone);
			oder.setAccount(acc);
			
		try {
			System.out.println(address);
			System.out.println(phone);
			orderDao.save(oder);
			System.out.println(oder.getId());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		for (CartSession item : list) {
		Orderdetail orderdetail = new Orderdetail();
		orderdetail.setPrice(item.getPrice());
		orderdetail.setOrder(oder);
		orderdetail.setProduct(item.getProduct());
		orderdetail.setQuantity(item.getQuantity());
		orderdetailDAO.save(orderdetail);
		}
		}
			
		
		return "redirect:/checkout.php"; 
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