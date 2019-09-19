package groceryshoppy.ogs.dao;

import java.util.List;

import groceryshoppy.ogs.entity.Cart;

public interface CartDAO {
	
	void deleteCart();
	boolean addProductToCart(Cart cart);
	List<Cart> getMyCart();
	List<Cart> getMyCartByEmai(String usernam);
	boolean deleteProductFromCart(Cart cart);
}
