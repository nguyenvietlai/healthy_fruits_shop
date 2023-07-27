package www.HealthyShop2023.Model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
/**
 * The persistent class for the imagesofproduct database table.
 * 
 */
@Getter @Setter
@Entity
@NamedQuery(name="Imagesofproduct.findAll", query="SELECT i FROM Imagesofproduct i")
public class Imagesofproduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Lob
	private String image;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="id_product")
	private Product product;


}