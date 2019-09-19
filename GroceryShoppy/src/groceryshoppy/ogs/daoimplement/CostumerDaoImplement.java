package groceryshoppy.ogs.daoimplement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import groceryshoppy.ogs.dao.CostumerDAO;
import groceryshoppy.ogs.entity.Costumer;
import groceryshoppy.ogs.util.DataHandler;

public class CostumerDaoImplement implements CostumerDAO {

	DataHandler dh = new DataHandler();
	
	@Override
	public boolean saveCostumer(Costumer cos) {
		boolean b;
		
		SessionFactory sf = dh.getSessionFactory();
		Session ses    = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.save(cos);
		tr.commit();
		ses.close();
		
		return false;
	}

	@Override
	public List<Costumer> getAllCostumers() {
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from Costumer");
		List<Costumer> costumer = query.list();
		tr.commit();
		ses.close();
		return costumer;
	}

	@Override
	public int validateCostumer(String username, String password) {
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from Costumer where email = :email");
		query.setString("email", username);
		List<Costumer> costumer = query.list();
		tr.commit();
		ses.close();
		if(costumer.isEmpty()){
			System.out.println("False");
			return 0;
		}else{
			System.out.println("True");
			Costumer cos = costumer.get(0);
			if(cos.getEmail().equals(username) && cos.getPassword().equals(password)){
				System.out.println(cos.getCosName()+" From If");
				return 1;
			}else{
				System.out.println(cos.getCosName()+" From Else");
				return 2;
			}
			
		}
	}
	
	@Override
	public Costumer getCostumerByUsername(String username) {
		
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from Costumer where email = :email");
		query.setString("email", username);
		List<Costumer> costumer = query.list();
		tr.commit();
		ses.close();
		
		return costumer.get(0);
	}
	
	@Override
	public int getCustomerCount() {
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from Costumer");
		List<Costumer> costumer = query.list();
		tr.commit();
		ses.close();
		return costumer.size();
	}
	
	public static void main(String[] args) {
		System.out.println("Run....");
		CostumerDAO d = new CostumerDaoImplement();
		d.validateCostumer("amjadalimirjat@gmail.com", "amju");
	}

	

}
