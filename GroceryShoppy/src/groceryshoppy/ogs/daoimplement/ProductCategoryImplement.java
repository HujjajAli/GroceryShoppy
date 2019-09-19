package groceryshoppy.ogs.daoimplement;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import groceryshoppy.ogs.dao.ProductCategoryDAO;
import groceryshoppy.ogs.entity.ProductCategory;
import groceryshoppy.ogs.util.DataHandler;

public class ProductCategoryImplement implements ProductCategoryDAO {

	DataHandler dh = new DataHandler();
	
	@Override
	public boolean saveCategory(ProductCategory pc) {
		boolean b;
		
		SessionFactory sf = dh.getSessionFactory();
		Session ses    = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.save(pc);
		tr.commit();
		ses.close(); 
		return false;
	}
	
	@Override
	public List<ProductCategory> getAllCategory() {
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from ProductCategory");
		List<ProductCategory> categories = query.list();
		tr.commit();
		ses.close();
		return categories;
	}

	@Override
	public List<ProductCategory> getCategoryByType(String name) {
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from ProductCategory where type = :type");
		query.setString("type", name);
		List<ProductCategory> categories = query.list();
		tr.commit();
		ses.close();
		return categories;
	}
	
	@Override
	public ProductCategory getCategoryByID(Long id) {
		
			SessionFactory sf = dh.getSessionFactory();
			Session ses     = sf.openSession();
			Transaction tr  = ses.beginTransaction();
			ProductCategory category = ses.get(ProductCategory.class, id);
			tr.commit();
			ses.close();
			return category;
		
	}
	
	public static void main(String[] args){
		ProductCategoryDAO pdao = new ProductCategoryImplement();
		java.util.List<ProductCategory> l = pdao.getCategoryByType("household");
		for(ProductCategory p:l){
			System.out.println(p.getCname());
		}
	}

	

	

}
