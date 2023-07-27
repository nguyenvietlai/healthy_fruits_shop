package www.HealthyShop2023.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import www.HealthyShop2023.Model.Category;
import www.HealthyShop2023.Model.Product;
import www.HealthyShop2023.Model.Report;
@EnableJpaRepositories
public interface productDAO extends JpaRepository<Product , Long>{
	public List<Product> findAllByPriceBetween(Double min,Double max);
	
	public Page<Product> findAllByNameLike(String name,Pageable pageable);
	
	@Query("select o from Product o where o.name like ?1")
	Page<Product> findByKeywords(String key,Pageable pageable);
	
	
	@Query("select new Report(o.category , sum(o.price) , "
			+ "count(o)) from Product o  group by o.category order by  sum(o.price) desc")
	List<Report> getInventoryByCategory();
	
//	public List<Product> findByDiscountOrderByDiscount(Float discount);
	@Query("select o from Product o where o.discount > 0 order by price desc limit 10")
	public List<Product> findByDiscountAfterOrderByPrice();
	
	
	@Query("select o from Product o where (o.price - (o.price * o.discount)) between ?1 and ?2  order by price ")
	public List<Product> findByPriceBetween(Double minDouble , Double maxDouble);
	
	public List<Product> findByCategory(Category cate);
	

}
