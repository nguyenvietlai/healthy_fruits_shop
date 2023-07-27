package www.HealthyShop2023.User.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import www.HealthyShop2023.DAO.orderDAO;
import www.HealthyShop2023.DAO.orderDetailDAO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.Order;
import www.HealthyShop2023.Service.sessionServices;
import www.HealthyShop2023.Utils.constant;

@Controller
public class Order_HistoryController {
	@Autowired
	private orderDAO orderDao;
	@Autowired
	private orderDetailDAO orderdetailDAO;
	@Autowired
	private sessionServices session;
	@GetMapping("/orderhistory.php")
	public String oderhistory(Model model) {
		Account acc = session.get(constant.CURRENT_USER);
		
		List<Order> list = orderDao.findByAccount(acc);
		
		model.addAttribute("data", list);
		return "user/order_history";
	}
}