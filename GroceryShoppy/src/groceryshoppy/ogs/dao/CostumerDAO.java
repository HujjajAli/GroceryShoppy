package groceryshoppy.ogs.dao;

import java.util.List;

import groceryshoppy.ogs.entity.Costumer;

public interface CostumerDAO {
	
	boolean saveCostumer(Costumer cos);
	int validateCostumer(String username,String password);
	int getCustomerCount();
	Costumer getCostumerByUsername(String username);
	List<Costumer> getAllCostumers();
}
