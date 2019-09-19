package groceryshoppy.ogs.daoimplement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import groceryshoppy.ogs.dao.CartDAO;
import groceryshoppy.ogs.entity.Cart;
import groceryshoppy.ogs.util.DataHandler;

public class CartDaoImplement implements CartDAO {

	DataHandler dh = new DataHandler();
	
	@Override
	public boolean addProductToCart(Cart cart) {
		
		SessionFactory sf = dh.getSessionFactory();
		Session ses    = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.save(cart);
		tr.commit();
		ses.close();
		
		return false;
	}

	@Override
	public List<Cart> getMyCart() {
		SessionFactory sf = dh.getSessionFactory();
		Session ses       = sf.openSession();
		Transaction tr    = ses.beginTransaction();
		Query query       = ses.createQuery("from Cart");
		List<Cart> mycart = query.list();
		tr.commit();
		ses.close();
		return mycart;
	}
	
	@Override
	public List<Cart> getMyCartByEmai(String usernam) {
		SessionFactory sf = dh.getSessionFactory();
		Session ses       = sf.openSession();
		Transaction tr    = ses.beginTransaction();
		Query query       = ses.createQuery("from Cart where email = :usernam");
		query.setString("usernam", usernam);
		tr.commit();
		ses.close();
		return query.list();
	}

	@Override
	public boolean deleteProductFromCart(Cart cart) {
		SessionFactory sf = dh.getSessionFactory();
		Session ses    = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.delete(cart);
		tr.commit();
		ses.close();
		return false;
	}
	
	public static void main(String[] args) {
		
		CartDAO d = new CartDaoImplement();
		/*Cart c = new Cart();
		c.setId(30);
		d.deleteProductFromCart(c);*/
		d.deleteCart();
	}

	@Override
	public void deleteCart() {
		SessionFactory sf = dh.getSessionFactory();
		Session ses    = sf.openSession();
		Transaction tr = ses.beginTransaction();
		Query query    = ses.createQuery("delete from Cart");
		query.executeUpdate();
		System.out.println("I hope everything is OK");
		tr.commit();
		ses.close();
	}

}
