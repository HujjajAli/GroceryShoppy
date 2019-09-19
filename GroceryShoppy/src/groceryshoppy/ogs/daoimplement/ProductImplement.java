package groceryshoppy.ogs.daoimplement;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import groceryshoppy.ogs.dao.ProductDAO;
import groceryshoppy.ogs.entity.Product;
import groceryshoppy.ogs.entity.ProductCategory;
import groceryshoppy.ogs.util.DataHandler;

public class ProductImplement implements ProductDAO {

	DataHandler dh = new DataHandler();
	
	@Override
	public boolean saveProduct(Product product) {
		
		boolean b;
		
		SessionFactory sf = dh.getSessionFactory();
		Session ses    = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.save(product);
		tr.commit();
		ses.close();
		
		return false;
	}
	
	@Override
	public boolean saveProductImages(Product product) {
		
		boolean b;
		
		SessionFactory sf = dh.getSessionFactory();
		Session ses    = sf.openSession();
		Transaction tr = ses.beginTransaction();
		ses.saveOrUpdate(product);
		tr.commit();
		ses.close();
		
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from Product");
	//	Query query     = ses.createQuery("FROM Product p ORDER BY p.cuisine");
		List<Product> products = query.list();
		tr.commit();
		ses.close();
		return products;
	}

	@Override
	public Product getProductById(Long id) {
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Product product = ses.get(Product.class, id);
		tr.commit();
		ses.close();
		return product;
	}

	@Override
	public List<Product> getProductsByName(String name) {
		
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from Product where name = :name");
		query.setString("name", name);
		List<Product> products = query.list();
		tr.commit();
		ses.close();
		return products;
		
	}
	
	@Override
	public List<Product> getProductsByCategory(int id) {
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from Product where proCate_id = :id");
		query.setInteger("id", id);
		List<Product> products = query.list();
		tr.commit();
		ses.close();
		return products;
	}
	
	@Override
	public List<Product> getSearchedProducts(String querystr) {
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("SELECT a FROM Product a WHERE a.name like ?1");
		query.setParameter(1, "%"+querystr+"%");
		List<Product> products = query.getResultList();
		tr.commit();
		ses.close();
		return products;
	}
	
	public static void main(String[] args){
		ProductImplement pi = new ProductImplement();
		List<Product> prs = pi.getAllProducts();
		for(Product p:prs){
			System.out.println(p.getName()+" - "+p.getCuisine());
		}
	//	List<Product> prs   = pi.getSearchedProducts("100g");
		
	//	long l = 5;
		//Long l = Long.valueOf((long)l);
		/*Product p1 = pi.getProductById(l);
		System.out.println(p1.getName());
		*/
		/*for(Product p: prs){
			System.out.println(p.getName());
		}*/
		
		//Product p = pi.getProductByIntId(8);
		//System.out.println(p.getName());
	}

	@Override
	public Set<String> getProductCompanies() {
		
		List<Product> products = getAllProducts();
		Set<String> companeis = new HashSet<String>();
		for(Product p:products){
			companeis.add(p.getCompaney());
		}
		return companeis;
	}

	@Override
	public Product getProductByName(String name) {
		List<Product> products = getProductsByName(name);
		Product pro = new Product();
		for(Product p:products){
			pro.setName(p.getName());
			pro.setPrice(p.getPrice());
			pro.setExtraprice(p.getExtraprice());
			pro.setDiscription(p.getDiscription());
			pro.setImage(p.getImage());
			pro.setImgs1(p.getImgs1());
			pro.setImgs2(p.getImgs2());
			pro.setImgs3(p.getImgs3());
		}
		return pro;
	}

	@Override
	public int getProductCount() {
		
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from Product");
		List<Product> products = query.list();
		tr.commit();
		ses.close();
		
		return products.size();
	}
	
	/*@Override
	public Product getProductByIntId(int id) {
		
		Product p = new Product();
		SessionFactory sf = dh.getSessionFactory();
		Session ses     = sf.openSession();
		
		Transaction tr  = ses.beginTransaction();
		Query query     = ses.createQuery("from Product where proId = :id");
		query.setInteger("id", id);
		List<Product> products = query.list();
		tr.commit();
		ses.close();
		p =  products.get(0);
		return p;
		
	}*/

}
