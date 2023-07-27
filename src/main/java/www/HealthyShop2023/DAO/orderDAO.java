package www.HealthyShop2023.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.Order;

public interface orderDAO extends JpaRepository<Order , Long>{
	public List<Order> findByAccount(Account account);

}
