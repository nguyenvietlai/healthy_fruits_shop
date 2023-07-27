package www.HealthyShop2023.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the products database table.
 * 
 */
@Getter @Setter
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean available;

	@Temporal(TemporalType.DATE)
	private Date createdate;


	private String description;

	private Float discount;


	private String image;

	private String name;

	private Double price;

	//bi-directional many-to-one association to CartSession
	@OneToMany(mappedBy="product")
	private List<CartSession> cartSessions;

	//bi-directional many-to-one association to Imagesofproduct
	@OneToMany(mappedBy="product")
	private List<Imagesofproduct> imagesofproducts;

	//bi-directional many-to-one association to Orderdetail
	@OneToMany(mappedBy="product")
	private List<Orderdetail> orderdetails;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="categoryid")
	private Category category;

	public void update(Product p) {
		this.category = p.getCategory();
		this.description = p.getDescription();
		this.image = p.getImage() ==null?this.image:p.getImage();
		this.name = p.getName();
		this.price = p.getPrice();
	}

}