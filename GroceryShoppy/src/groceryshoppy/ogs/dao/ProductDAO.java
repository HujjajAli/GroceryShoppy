package groceryshoppy.ogs.dao;

import java.util.List;
import java.util.Set;

import groceryshoppy.ogs.entity.Product;

public interface ProductDAO {
	
	boolean saveProduct(Product product);
	boolean saveProductImages(Product product);
	int     getProductCount();
	List<Product> getAllProducts();
	List<Product> getProductsByName(String name);
	List<Product> getProductsByCategory(int id);
	List<Product> getSearchedProducts(String querystr);
	Set<String>   getProductCompanies();
	Product       getProductByName(String name);
	Product       getProductById(Long id);
	
	

}
