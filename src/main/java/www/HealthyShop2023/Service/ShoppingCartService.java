package www.HealthyShop2023.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import www.HealthyShop2023.DTO.ProductDTO;
import www.HealthyShop2023.Model.CartSession;

public interface ShoppingCartService {

	ProductDTO add(Long id, Long id_user);

	void remove(Long id);

	ProductDTO update(Long id, int qty);

	void clear();

	Collection<ProductDTO> getItems();

	int getCount();

	double getAmount();

	int size();

	void loadmycart(List<CartSession> data);
	

}