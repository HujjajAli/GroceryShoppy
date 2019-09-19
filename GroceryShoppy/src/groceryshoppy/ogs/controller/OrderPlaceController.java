package groceryshoppy.ogs.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import groceryshoppy.ogs.dao.CartDAO;
import groceryshoppy.ogs.dao.CostumerDAO;
import groceryshoppy.ogs.dao.OrderDAO;
import groceryshoppy.ogs.daoimplement.CartDaoImplement;
import groceryshoppy.ogs.daoimplement.CostumerDaoImplement;
import groceryshoppy.ogs.daoimplement.OrderDaoImplement;
import groceryshoppy.ogs.entity.Cart;
import groceryshoppy.ogs.entity.Cos_Order;
import groceryshoppy.ogs.entity.Costumer;
import groceryshoppy.ogs.entity.OrderDetail;

/**
 * Servlet implementation class OrderPlaceController
 */
@WebServlet("/OrderPlaceController")
public class OrderPlaceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	OrderDAO    od     = new OrderDaoImplement();
	CartDAO     cd     = new CartDaoImplement();  
	CostumerDAO cosdao = new CostumerDaoImplement();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderPlaceController() {
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
		Date   dobj = new Date(); 
		String date = dobj.toString();
		String time = ""+dobj.getHours()+":"+dobj.getMinutes();
		List<Cart> cart_Items = cd.getMyCart();
		
		
		String fname   = request.getParameter("fname");
		String email   = request.getParameter("email");
		String number  = request.getParameter("number");
		String address = request.getParameter("address");
		String city    = request.getParameter("city");
		String addtype = request.getParameter("addtype");
		
		
		
		Cos_Order co = new Cos_Order();
		
		Costumer cos =  cosdao.getCostumerByUsername(email);
		
		co.setCostumerID(cos.getId());
		co.setD_o_o(date);
		co.setTime_O(time);
		co.setStatus("Panding");
		co.setFname(fname);
		co.setMobile(number);
		co.setAddress(address+", "+city);
		co.setTotalPrice(od.getTotalPrice());
		
		od.addOrder(co);  //Adding Order to Database
		
		int orderID = od.getLastOrderID();
		
		for(Cart c:cart_Items){
			OrderDetail o_det = new OrderDetail();
			o_det.setOrder_ID(orderID);
			o_det.setProduct_ID(c.getProductID());
			od.addOrderDetails(o_det);  //Adding OrderDetail to Detabase 
		}
		cd.deleteCart();
		request.getRequestDispatcher("adminIndexPage.jsp").forward(request, response);
	}

}
