package www.HealthyShop2023.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import www.HealthyShop2023.DAO.CartSessionDAO;
import www.HealthyShop2023.DAO.productDAO;
import www.HealthyShop2023.DTO.ProductDTO;
import www.HealthyShop2023.Model.Account;
import www.HealthyShop2023.Model.CartSession;
import www.HealthyShop2023.Model.Product;
import www.HealthyShop2023.Utils.ManagerUser;



@Service
@SessionScope
public class ShoppingCartServiceImpl implements ShoppingCartService{
	 @Autowired
	 private productDAO productDao;
	 @Autowired
	 private CartSessionDAO cartdao;
	 
	 Map<Long, ProductDTO> map = new HashMap<>();
	
		@Autowired
		private sessionServices sessionservice;
	 
	@Override
	public ProductDTO add(Long id, Long id_user) {
		ProductDTO productDTO = map.get(id);
		Account account = ManagerUser.checklogin(sessionservice);
		if(account != null) {
			if (!checkProduct(productDTO)) {
				Optional<Product> pro = productDao.findById(Long.valueOf(id));
				productDTO = converProductToProductDTO(pro.get());
				map.put(id, productDTO);
				CartSession cartss = converProductToCartSession(productDTO,id_user);
				cartdao.save(cartss);
				
			}else {
				productDTO.setQty(productDTO.getQty()+1);
				Product product  = new Product();			product.setId(id);
				CartSession cartSession = cartdao.findByProductAndAccount(product, account);
				if(cartSession!=null) {
					cartSession.setQuantity(productDTO.getQty());
					cartdao.save(cartSession);
				}
			}
		}
	
		return productDTO;
	}
	private ProductDTO converProductToProductDTO(Product pro) {
		ProductDTO productDTO = new ProductDTO(pro);
		return productDTO;
	}
	
	private CartSession converProductToCartSession(ProductDTO prodto, Long id_user) {
		
		CartSession cartsession = new CartSession(prodto,id_user);
		return cartsession;
	}
	private boolean checkProduct(	ProductDTO productDTO ) {
		return productDTO != null;
	}

	@Override
	public void remove(Long id) {
		Account account = ManagerUser.checklogin(sessionservice);
		ProductDTO productDTO = map.get(id);
		if(account != null && productDTO !=null) {
			Product product  = new Product();			
			product.setId(id);
			CartSession cartSession = cartdao.findByProductAndAccount(product, account);
			if(cartSession != null) {
				cartdao.deleteById(cartSession.getId());
				map.remove(id);
			}

		}
		
	}

	@Override
	public ProductDTO update(Long id, int qty ) {
		// TODO Auto-generated method stub
		ProductDTO productDTO = map.get(id);
		if(checkProduct(productDTO)) {
			productDTO.setQty(qty);
			Account account = ManagerUser.checklogin(sessionservice);
			if(account != null) {
				Product product  = new Product();
				product.setId(id);
				CartSession cartSession = cartdao.findByProductAndAccount(product, account);
				cartSession.setQuantity(qty);
				cartdao.save(cartSession);
			}
		}
		
		return productDTO;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		map.clear();
	}



	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return map.values().stream()
				.mapToInt(productDTO -> productDTO.getQty()).sum();
	}

	@Override
	public double getAmount() {
		// TODO Auto-generated method stub
		return  map.values().stream()
				.mapToDouble(productDTO -> productDTO.getPrice()*productDTO.getQty()).sum();
	}
	@Override
	public Collection<ProductDTO> getItems() {
		map.values().forEach(item->{
			System.out.println(item.getImage());
		});

		return map.values();
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return map.size();
	}
	@Override
	public void loadmycart(List<CartSession> data) {
		map.clear();
		data.forEach(item ->{
			map.put(item.getProduct().getId(), convertCartSSToProductDTO(item));
		});

	}
	private ProductDTO convertCartSSToProductDTO(CartSession cartss) {
		ProductDTO prodto = new ProductDTO();
		prodto.setId(cartss.getProduct().getId());
		prodto.setQty(cartss.getQuantity());
		prodto.setName(cartss.getProduct().getName());
		prodto.setPrice(cartss.getPrice());
		prodto.setImage(cartss.getProduct().getImage());
		return prodto;
	}
	

}
