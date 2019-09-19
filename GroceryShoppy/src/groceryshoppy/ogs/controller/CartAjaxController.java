package groceryshoppy.ogs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import groceryshoppy.ogs.dao.CartDAO;
import groceryshoppy.ogs.dao.ProductDAO;
import groceryshoppy.ogs.daoimplement.CartDaoImplement;
import groceryshoppy.ogs.daoimplement.ProductImplement;
import groceryshoppy.ogs.entity.Cart;
import groceryshoppy.ogs.entity.Product;

/**
 * Servlet implementation class CartAjaxController
 */
@WebServlet("/CartAjaxController")
public class CartAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductDAO pdao = new ProductImplement(); 
	CartDAO    cdao = new CartDaoImplement();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartAjaxController() {
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
		Cart cart = new Cart();
		
		String action = request.getParameter("action");
		
		if(action.equals("add")){
			//PrintWriter out = response.getWriter();
			String id    = request.getParameter("id");
		//	String email = request.getParameter("email"); 
			System.out.println("Message From Cart Ajax Call id is "+id);
		//	System.out.println("Message From Cart Ajax Call id is "+email);
			
			Product product = pdao.getProductById(Long.parseLong(id));
			
			cart.setProductID(product.getProId());
			cart.setpName(product.getName());
			cart.setpImage(product.getImage());
			cart.setPrice(product.getPrice());
			cart.setEmail(request.getSession().getAttribute("sesemail").toString());
			cart.setSel_Num(1);
			cart.setQuantity(1);
			
			cdao.addProductToCart(cart);
		}else if(action.equals("delete")){
			String id = request.getParameter("id");
			System.out.println("Message From Cart Ajax Call id is "+id);
			
			Product product = pdao.getProductById(Long.parseLong(id));
			cart.setId(Integer.parseInt(id));
			cdao.deleteProductFromCart(cart); 
		}else{
			System.out.println("Else is Nothing");
			
			
		}
		
		
	}

}
