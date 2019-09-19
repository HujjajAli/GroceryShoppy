package groceryshoppy.ogs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import groceryshoppy.ogs.dao.AdminDAO;
import groceryshoppy.ogs.daoimplement.AdminDaoImplement;

@Entity
public class Admin {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String username;
	private String password;
	private String admin;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	public static void main(String[] args) {
		AdminDAO ad = new AdminDaoImplement();
		Admin admin = new Admin();
		admin.setAdmin("Nasir Hussain");
		admin.setUsername("nasirali@yahoo.com");
		admin.setPassword("1234");
		
		ad.saveAdmin(admin);
	}
	
}
