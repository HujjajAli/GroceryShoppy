package groceryshoppy.ogs.daoimplement;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import groceryshoppy.ogs.dao.OrderDAO;
import groceryshoppy.ogs.entity.Cart;
import groceryshoppy.ogs.entity.Cos_Order;
import groceryshoppy.ogs.entity.OrderDetail;
import groceryshoppy.ogs.util.DataHandler;

public class OrderDaoImplement implements OrderDAO {
	
	DataHandler dh = new DataHandler();
	
	
	@Override
	public void addOrder(Cos_Order order) {
		SessionFactory sf = dh.getSessionFactory();
		Session ses    = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.save(order);
		tr.commit();
		ses.close();
		
	}
	
	@Override
	public void addOrderDetails(OrderDetail orderDetail) {
		SessionFactory sf = dh.getSessionFactory();
		Session ses    = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.save(orderDetail);
		tr.commit();
		ses.close();
	}
	
	@Override
	public double getTotalPrice() {
		SessionFactory sf = dh.getSessionFactory();
		Session ses       = sf.openSession();
		Transaction tr    = ses.beginTransaction();
		Query query       = ses.createQuery("from Cart");
		List<Cart> mycart = query.list();
		tr.commit();
		ses.close();
		
		double p = 0.0;
		for(Cart c : mycart){
			p += c.getPrice();
		}
		System.out.println("Total "+p);
		return p;
	}
	
	@Override
	public int getLastOrderID() {
		int id = 0;
		SessionFactory sf     = dh.getSessionFactory();
		Session ses           = sf.openSession();
		Transaction tr        = ses.beginTransaction();
		Query query           = ses.createQuery("from Cos_Order");
		List<Cos_Order> list  = query.list();
		tr.commit();
		ses.close();
		for(Cos_Order co:list){
			id = co.getId();
		}
		return id;
	}
	
	@Override
	public List<Cos_Order> getAllOrders() {
		SessionFactory sf     = dh.getSessionFactory();
		Session ses           = sf.openSession();
		Transaction tr        = ses.beginTransaction();
		Query query           = ses.createQuery("from Cos_Order");
		List<Cos_Order> list  = query.list();
		tr.commit();
		ses.close();
		 
		return list;
	}
	
	@Override
	public List<OrderDetail> getOrderDetailByOrderID(int id) {
		SessionFactory sf     = dh.getSessionFactory();
		Session ses           = sf.openSession();
		Transaction tr        = ses.beginTransaction();
		Query query           = ses.createQuery("from OrderDetail o where order_ID = :order_ID ORDER BY o.product_ID");
		query.setInteger("order_ID", id);
		List<OrderDetail> list = query.list();
		tr.commit();
		ses.close();
		return list;
	}
	
	@Override
	public int getOrderCount() {
		
		SessionFactory sf     = dh.getSessionFactory();
		Session ses           = sf.openSession();
		Transaction tr        = ses.beginTransaction();
		Query query           = ses.createQuery("from Cos_Order");
		List<Cos_Order> list  = query.list();
		tr.commit();
		ses.close();
		
		return list.size();
	}
	
	@Override
	public List<Cos_Order> getOrdersByCustomerID(int id) {
		SessionFactory sf     = dh.getSessionFactory();
		Session ses           = sf.openSession();
		Transaction tr        = ses.beginTransaction();
		Query query           = ses.createQuery("from Cos_Order where costumerID = :id");
		query.setInteger("id", id);
		List<Cos_Order> list  = query.list();
		tr.commit();
		ses.close();
		
		return list;
	}
	
	public static void main(String[] args) {
		Date   dobj = new Date(); 
		String date = dobj.toString();//dobj.getDay()+"/"+dobj.getMonth()+"/"+dobj.getYear();
		String time = ""+dobj.getHours()+":"+dobj.getMinutes();
		/*System.out.println("Date "+date);
		System.out.println("Time "+time);*/
		OrderDAO d = new OrderDaoImplement();
		//d.getTotalPrice();
		
		/*Cos_Order order = new Cos_Order();
		
		order.setCostumerID(15);
		order.setStatus("panding");
		order.setD_o_o(date);
		order.setTime_O(time);
		order.setTotalPrice(3500);
		
		
	//	d.addOrder(order);
		
		OrderDetail od = new OrderDetail();
		od.setOrder_ID(1);
		od.setProduct_ID(2);*/
		/*List<OrderDetail> dol = d.getOrderDetailByOrderID(55);
		for(OrderDetail odd:dol){
			System.out.println(odd.getId());
			System.out.println(odd.getOrder_ID());
			System.out.println(odd.getProduct_ID());
		}*/
		List<Cos_Order> ods = d.getOrdersByCustomerID(15);
		for(Cos_Order o:ods){
			System.out.println(o.getId()+"==="+o.getCostumeDate()+"==="+o.getTotalPrice());
		}
	}

	


}
