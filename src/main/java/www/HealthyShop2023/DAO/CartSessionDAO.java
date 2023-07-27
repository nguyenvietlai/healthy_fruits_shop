package www.HealthyShop2023.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.CartSession;
import www.HealthyShop2023.Model.Product;



public interface CartSessionDAO extends JpaRepository<CartSession , Long>{ 
	public List<CartSession> findByAccount(Account acc);
	public CartSession findByProductAndAccount(Product p,Account acc);
	public CartSession   deleteByProductAndAccount(Product p,Account acc);
	
}
