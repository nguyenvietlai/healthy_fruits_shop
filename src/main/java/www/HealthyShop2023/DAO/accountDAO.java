package www.HealthyShop2023.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import www.HealthyShop2023.Model.Account;
import org.springframework.data.domain.Page;



public interface accountDAO extends JpaRepository<Account	, Long>{
	public Account findByUsernameAndPassword(String username,String password);
	public Account findByUsername(String username);
	 @Modifying
	    @Query("UPDATE Account a SET a.activated = false WHERE a.id = ?1")
	    void updateActivatedStatus(Long accountId);
	 @Query("SELECT o FROM Account o WHERE o.username LIKE ?1")
	 Page<Account> findAllByNameLike(String keywords, Pageable pageable);
	 public Account findByEmail(String email);
}

