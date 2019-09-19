package groceryshoppy.ogs.daoimplement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import groceryshoppy.ogs.dao.AdminDAO;
import groceryshoppy.ogs.entity.Admin;
import groceryshoppy.ogs.util.DataHandler;

public class AdminDaoImplement implements AdminDAO {
	
	DataHandler dh = new DataHandler();
	
	

	@Override
	public int validateAdmin(String username, String password) {
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from Admin where username = :username");
		query.setString("username", username);
		List<Admin> admin = query.list();
		tr.commit();
		ses.close();
		if(admin.isEmpty()){
			System.out.println("False");
			return 0;
		}else{
			Admin ad = admin.get(0);
			System.out.println(password+" Admin Password "+ad.getPassword());
			System.out.println(username+" Admin Emai "+ad.getUsername());
			
			if(ad.getUsername().equals(username) && ad.getPassword().equals(password)){
				System.out.println(ad.getUsername()+" From IF");
				return 1;
			}else{
				System.out.println(ad.getUsername()+" From Else");
				return 2;
			}
		}
	}



	@Override
	public boolean saveAdmin(Admin admin) {
		
		SessionFactory sf = dh.getSessionFactory();
		Session ses    = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.save(admin);
		tr.commit();
		ses.close();
		
		return false;
	}



	@Override
	public Admin getAdminByUsername(String username) {
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from Admin where username = :username");
		query.setString("username", username);
		List<Admin> admin = query.list();
		tr.commit();
		ses.close();
		return admin.get(0);
	}

	public static void main(String[] args) {
		AdminDAO ad = new AdminDaoImplement();
		int i = ad.validateAdmin("nasirali@yahoo.com", "1234");
		System.out.println("I = "+i);
	}
}
