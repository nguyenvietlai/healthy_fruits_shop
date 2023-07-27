package www.HealthyShop2023.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import www.HealthyShop2023.Model.Imagesofproduct;
import www.HealthyShop2023.Model.Product;

public interface imagesOfProduct extends JpaRepository<Imagesofproduct	, Long>{

	public Imagesofproduct findByProductAndImage(Product product,String imageName);
	public List<Imagesofproduct> findByProduct(Product product);
}
