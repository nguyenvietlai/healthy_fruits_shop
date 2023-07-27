package www.HealthyShop2023.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import www.HealthyShop2023.DTO.OrderReport;
import www.HealthyShop2023.Model.Orderdetail;

public interface orderDetailDAO extends JpaRepository<Orderdetail , Long>{
	@Query("select new OrderReport(o.product.category.name , sum(o.price * o.quantity)) "
			+ " from Orderdetail o group by o.product.category.name ")
	public List<OrderReport> findReports();
}
