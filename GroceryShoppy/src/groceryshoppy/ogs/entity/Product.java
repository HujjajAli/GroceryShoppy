package groceryshoppy.ogs.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long proId;         //Product ID
	private String name;        //Product Name 
	private String companey;    //Product Companey Name
	private String discription; //Product Discription
	private String preference;  //User Preference from Vegetarian and Non Vegetarian
	private String cuisine;     //Product Use in Main Cuisine   
	private String image;       //Product Image Name
	private String imgs1;       //Product Image 1 for Single Page
	private String imgs2;       //Product Image 2 for Single Page
	private String imgs3;       //Product Image 3 for Single Page
	private String dealimg;     //Product Image for Sid Deals
	private String deals;       //Deals on Product is off or on
	private String age;         //Product Age that Product is New or Old
	private double price;       //Product Price
	private double extraprice;  //Product Orginal or Extra Price
	private int discount;       //Discount on a Product
	private int soldcount;      //For How Many times this Product has Sold
	@ManyToOne
	private ProductCategory proCate; 
	private String desVal[] ;
	
	
	public long getProId() {
		return proId;
	}
	public void setProId(long proId) {
		this.proId = proId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompaney() {
		return companey;
	}
	public void setCompaney(String companey) {
		this.companey = companey;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getPreference() {
		return preference;
	}
	public void setPreference(String preference) {
		this.preference = preference;
	}
	public String getCuisine() {
		return cuisine;
	}
	public void setCuisine(String cuisine) {
		this.cuisine = cuisine;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getImgs1() {
		return imgs1;
	}
	public void setImgs1(String imgs1) {
		this.imgs1 = imgs1;
	}
	public String getImgs2() {
		return imgs2;
	}
	public void setImgs2(String imgs2) {
		this.imgs2 = imgs2;
	}
	public String getImgs3() {
		return imgs3;
	}
	public void setImgs3(String imgs3) {
		this.imgs3 = imgs3;
	}
	public String getDealimg() {
		return dealimg;
	}
	public void setDealimg(String dealimg) {
		this.dealimg = dealimg;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getExtraprice() {
		return extraprice;
	}
	public void setExtraprice(double extraprice) {
		this.extraprice = extraprice;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public ProductCategory getProCate() {
		return proCate;
	}
	public void setProCate(ProductCategory proCate) {
		this.proCate = proCate;
	}
	public String getDeals() {
		return deals;
	}
	public void setDeals(String deals) {
		this.deals = deals;
	}

	public String[] getDesVal() {
		this.desVal = this.discription.split(",");
		return desVal;
	}
	public int getSoldcount() {
		return soldcount;
	}
	public void setSoldcount(int soldcount) {
		this.soldcount = soldcount;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	
	/*public static void main(String[] args){
		String s = "ab,cb,dc";
		String arr[] = s.split(","); 
		for(String v:arr){
			System.out.println(v);
		}
	}*/
	
	
	
}
