package groceryshoppy.ogs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cos_Order {
	
	/*public static void main(String[] args) {
		Cos_Order c = new Cos_Order();
		c.setD_o_o(new Date().toString());
		System.out.println("Full Date = "+c.getD_o_o());
		System.out.println("Customized = "+c.getCostumeDate());
		
	}*/
	
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String fname;
	private String mobile;
	private String address;
	private int costumerID;
	private double totalPrice;
	private String d_o_o;//Date of Order of Placement
	private String time_O; //Exact Time of Order
	private String status;
	
	private String costumeDate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCostumerID() {
		return costumerID;
	}
	public void setCostumerID(int costumerID) {
		this.costumerID = costumerID;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getD_o_o() {
		return d_o_o;
	}
	public void setD_o_o(String d_o_o) {
		this.d_o_o = d_o_o;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTime_O() {
		return time_O;
	}
	public void setTime_O(String time_O) {
		this.time_O = time_O;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCostumeDate() {
		String dv[] = getD_o_o().split(" ");//125
		this.costumeDate = dv[2]+"/"+dv[1]+"/"+dv[5];
		return costumeDate;
	}
	
	
}
