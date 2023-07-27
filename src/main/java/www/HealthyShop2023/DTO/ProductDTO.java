package www.HealthyShop2023.DTO;





import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import www.HealthyShop2023.Model.Product;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends Product{
	
	private static final long serialVersionUID = 1L;
	private int qty = 1;
	public ProductDTO(Product pro) {
		super.setId(pro.getId());
		super.setAvailable(pro.getAvailable());
		super.setCreatedate(pro.getCreatedate());
		super.setImage(pro.getImage());
		super.setName(pro.getName());
		super.setPrice(pro.getPrice());
		super.setDescription(pro.getDescription());
		super.setOrderdetails(pro.getOrderdetails());
		super.setCategory(pro.getCategory());
		this.qty = 1;
	}
	
}
