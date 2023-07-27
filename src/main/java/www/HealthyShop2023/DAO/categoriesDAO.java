package www.HealthyShop2023.DAO;

import org.springframework.data.jpa.repository.JpaRepository;


import www.HealthyShop2023.Model.Category;

public interface categoriesDAO extends JpaRepository<Category	, Long>{

}
