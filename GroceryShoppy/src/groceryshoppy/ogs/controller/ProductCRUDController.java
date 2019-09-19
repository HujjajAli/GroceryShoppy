package groceryshoppy.ogs.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import groceryshoppy.ogs.dao.ProductCategoryDAO;
import groceryshoppy.ogs.dao.ProductDAO;
import groceryshoppy.ogs.daoimplement.ProductCategoryImplement;
import groceryshoppy.ogs.daoimplement.ProductImplement;
import groceryshoppy.ogs.entity.Product;
import groceryshoppy.ogs.entity.ProductCategory;



/**
 * Servlet implementation class ProductCRUDController
 */
@WebServlet("/ProductCRUDController")
public class ProductCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductCategoryDAO pcdao = new ProductCategoryImplement();
	ProductDAO         pdao  = new ProductImplement(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductCRUDController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product pro = new Product();
		String action         = request.getParameter("action");
		
		if(action.equals("Save Product")){
			
			
			String product         = request.getParameter("product");
			String productcategory = request.getParameter("productcategory");
			String discription     = request.getParameter("discription");
			String companey = request.getParameter("companey");
			String priceS = request.getParameter("price");
			String discountS = request.getParameter("discount");
			String type = request.getParameter("type");
			String cuisine = request.getParameter("cuisine");
			String deals = request.getParameter("deals");
			
			Long prodcat   = Long.parseLong(productcategory);
			double priceD  = Double.parseDouble(priceS);
			int discountI = Integer.parseInt(discountS);
			ProductCategory category = pcdao.getCategoryByID(prodcat);
			
			pro.setName(product);
			pro.setProCate(category);
			pro.setDiscription(discription);
			pro.setCompaney(companey);
			pro.setPrice(priceD);
			pro.setExtraprice((priceD+30));
			pro.setDiscount(discountI);
			pro.setCuisine(cuisine);
			pro.setPreference(type);
			pro.setDeals(deals);
			pro.setAge("new");
			
			pdao.saveProduct(pro);
		}else if(action.equals("Save Images")){
			String product = request.getParameter("product");
			String mainImage = request.getParameter("image");
			String dealImage = request.getParameter("dealimg");
			String img1 = request.getParameter("img_one");
			String img2 = request.getParameter("img_two");
			String img3 = request.getParameter("img_three");
			
			pro = pdao.getProductById(Long.parseLong(product));
			
			//pro.setProId(Integer.parseInt(product));
			pro.setImage(mainImage);
			pro.setDealimg(dealImage);
			pro.setImgs1(img1);
			pro.setImgs2(img2);
			pro.setImgs3(img3);
			
			
			System.out.println(pro.getProId());
			System.out.println(pro.getImage());
			System.out.println(pro.getDealimg());
			System.out.println(pro.getImgs1());
			System.out.println(pro.getImgs2());
			System.out.println(pro.getImgs3());
			System.out.println(pro.getName());
			System.out.println(pro.getCompaney());
			System.out.println(pro.getCuisine());
			System.out.println(pro.getPreference());
			System.out.println(pro.getPrice());
			
			pdao.saveProductImages(pro);
			request.getRequestDispatcher("adminAddProductsImages.jsp").forward(request, response);
		}else {
			String querystr = request.getParameter("search");
			System.out.println("Query is :"+querystr);
			List<Product> searched_products = pdao.getSearchedProducts(querystr);
			request.setAttribute("searched_products", searched_products);
			request.getRequestDispatcher("product_search.jsp").forward(request, response);
			/*for(Product p:searched_products){
				System.out.println(p.getName());
			}*/
		}
	}

}
