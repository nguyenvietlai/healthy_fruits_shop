package www.HealthyShop2023.collections;

import java.util.Comparator;

import www.HealthyShop2023.Model.Product;

public class SortByPrice implements Comparator<Product>{

	@Override
	public int compare(Product o1, Product o2) {
		return Double.compare(o1.getPrice(), o2.getPrice());
	}

}
