package www.HealthyShop2023.admin.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import www.HealthyShop2023.DAO.orderDAO;
import www.HealthyShop2023.DAO.orderDetailDAO;
import www.HealthyShop2023.DTO.OrderReport;

@Controller
@EnableTransactionManagement
public class adminStatistical {
	@Autowired
	private orderDAO orderdao;
	@Autowired
	private orderDetailDAO orderDetailDao;
	

	@GetMapping("/admin/users-statistical")

	public String displayManagerProduct(Model model, @RequestParam("p") Optional<Integer> p) {
		 List<OrderReport> list =orderDetailDao.findReports();

		model.addAttribute("orders", list);
		
			return "admin/user-statistical";
	}
	
}
