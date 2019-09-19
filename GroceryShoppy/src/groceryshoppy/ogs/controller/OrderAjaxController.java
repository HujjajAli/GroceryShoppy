package groceryshoppy.ogs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import groceryshoppy.ogs.dao.OrderDAO;
import groceryshoppy.ogs.dao.ProductDAO;
import groceryshoppy.ogs.daoimplement.OrderDaoImplement;
import groceryshoppy.ogs.daoimplement.ProductImplement;
import groceryshoppy.ogs.entity.Cos_Order;
import groceryshoppy.ogs.entity.OrderDetail;
import groceryshoppy.ogs.entity.Product;

/**
 * Servlet implementation class OrderAjaxController
 */
@WebServlet("/OrderAjaxController")
public class OrderAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	OrderDAO od     = new OrderDaoImplement();
	ProductDAO pdao = new ProductImplement();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderAjaxController() {
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
		System.out.println("At Order Ajax");
		PrintWriter w = response.getWriter();
		String id   = request.getParameter("id");
		String act  = request.getParameter("act");
		
		if(act.equals("customerorders")){
			List<Cos_Order> ods = od.getOrdersByCustomerID(Integer.parseInt(id));
			for(Cos_Order o:ods){
				w.print("<tr>");
					w.println("<td>ODR"+o.getId()+"</td>");
					w.println("<td>"+o.getFname()+"</td>");
					w.println("<td>"+o.getTotalPrice()+"</td>");
					w.println("<td>"+o.getD_o_o()+"</td>");
					w.println("<td>"+o.getMobile()+"</td>");
					w.println("<td>"+o.getStatus()+"</td>");
					w.println("<td>"+o.getAddress()+"</td>");
				w.println("</tr>");
			}
			
			
		}else if(act.equals("showorderdetails")){
			List<OrderDetail> ord_details = od.getOrderDetailByOrderID(Integer.parseInt(id));
			//ArrayList prosIDs = new ArrayList(); 
			//int quantity = 0;
			for(OrderDetail ord:ord_details){
				
				
				
				/*if(prosIDs.contains(ord.getProduct_ID())){
					quantity++;
				}else{
					quantity = 1;
				}*/
					
				Product p = pdao.getProductById(ord.getProduct_ID());
				w.print("<tr>");
						w.println("<td>"+p.getName()+"</td>");
						w.println("<td>"+p.getPrice()+"</td>");
						w.println("<td>"+1+"</td>");
						w.println("<td>ODR"+ord.getOrder_ID()+"</td>");
				w.println("</tr>");
				
				
				
			}
		}
		
		
		
		
	}

}
