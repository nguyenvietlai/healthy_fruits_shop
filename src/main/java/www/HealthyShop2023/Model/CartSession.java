package www.HealthyShop2023.Model;

import java.io.Serializable;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import www.HealthyShop2023.DTO.ProductDTO;

import java.util.Date;


/**
 * The persistent class for the cart_session database table.
 * 
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name="cart_session")
@NamedQuery(name="CartSession.findAll", query="SELECT c FROM CartSession c")
public class CartSession implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.DATE)
	private Date createdate;

	private Double price;

	private int quantity;

	@Temporal(TemporalType.DATE)
	private Date updatedate;

	//bi-directional many-to-one association to Account
	@ManyToOne
	@JoinColumn(name="id_user")
	private Account account;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="productid")
	private Product product;

	public CartSession(ProductDTO pro, Long id_user) {
		setId(pro.getId());
		setCreatedate(pro.getCreatedate());
		setPrice(pro.getPrice());
		setQuantity(pro.getQty());
		setUpdatedate(new Date());
		Account u = new Account();
		u.setId(id_user);
		setAccount(u);
		Product p = new Product();
		p.setId(pro.getId());
		setProduct(p);
		
	}
	
}