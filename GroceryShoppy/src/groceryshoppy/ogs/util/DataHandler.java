package groceryshoppy.ogs.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import groceryshoppy.ogs.entity.Admin;
import groceryshoppy.ogs.entity.Cart;
import groceryshoppy.ogs.entity.Cos_Order;
import groceryshoppy.ogs.entity.Costumer;
import groceryshoppy.ogs.entity.OrderDetail;
import groceryshoppy.ogs.entity.Product;
import groceryshoppy.ogs.entity.ProductCategory;



public class DataHandler {

	
	
	private static SessionFactory sf = null;
	
	public DataHandler(){
		Configuration conf = new Configuration().configure();
		conf.addAnnotatedClass(ProductCategory.class);
		conf.addAnnotatedClass(Product.class);
		conf.addAnnotatedClass(Costumer.class);
		conf.addAnnotatedClass(Cart.class);
		conf.addAnnotatedClass(Cos_Order.class);
		conf.addAnnotatedClass(OrderDetail.class);
		conf.addAnnotatedClass(Admin.class);
		sf = conf.buildSessionFactory();
	}

	public static SessionFactory getSessionFactory(){
		return sf;
	}
}
