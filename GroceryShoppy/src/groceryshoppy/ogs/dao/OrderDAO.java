package groceryshoppy.ogs.dao;

import java.util.List;

import groceryshoppy.ogs.entity.Cos_Order;
import groceryshoppy.ogs.entity.OrderDetail;

public interface OrderDAO {
	
	void addOrder(Cos_Order order);
	void addOrderDetails(OrderDetail orderDetail);
	double  getTotalPrice();
	int getOrderCount();
	int getLastOrderID();
	List<Cos_Order> getAllOrders();
	List<Cos_Order> getOrdersByCustomerID(int id);
	List<OrderDetail> getOrderDetailByOrderID(int id);
}
