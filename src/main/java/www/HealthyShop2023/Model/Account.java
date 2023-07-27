package www.HealthyShop2023.Model;

import java.io.Serializable;

import java.util.List;

import org.hibernate.validator.constraints.UniqueElements;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


/**
 * The persistent class for the accounts database table.
 * 
 */
@Getter @Setter
@Entity
@Table(name="accounts")
@NamedQuery(name="Account.findAll", query="SELECT a FROM Account a")
public class Account implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Boolean activated;

	private Boolean admin;

	private String email;
	
	private String fullname;
	
	private String password;
	
	private String photo;
	
	private String username;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="account")
	private List<Order> orders;



}