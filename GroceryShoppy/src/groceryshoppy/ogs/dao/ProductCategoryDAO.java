package groceryshoppy.ogs.dao;

import java.util.List;

import groceryshoppy.ogs.entity.ProductCategory;

public interface ProductCategoryDAO {
	
	boolean saveCategory(ProductCategory pc);
	List<ProductCategory> getAllCategory();
	List<ProductCategory> getCategoryByType(String name);
	ProductCategory getCategoryByID(Long id);
	
}
