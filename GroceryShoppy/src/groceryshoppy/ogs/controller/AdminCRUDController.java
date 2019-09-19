package groceryshoppy.ogs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import groceryshoppy.ogs.dao.ProductCategoryDAO;
import groceryshoppy.ogs.daoimplement.ProductCategoryImplement;
import groceryshoppy.ogs.entity.ProductCategory;



/**
 * Servlet implementation class AdminCRUDController
 */
@WebServlet("/AdminCRUDController")
public class AdminCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductCategoryDAO pdao = new ProductCategoryImplement();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCRUDController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String event = request.getParameter("event");
		
		String cname = request.getParameter("cname");
		String disc  = request.getParameter("disc");
		String type  = request.getParameter("type");
		
		ProductCategory pc = new ProductCategory();
		
		pc.setCname(cname);
		pc.setDiscription(disc);
		pc.setType(type);
		
		
		
		System.out.println("Hello Name :"+cname);
		System.out.println("Hello Discription:"+cname);
		System.out.println("Hello Type:"+type);
		pdao.saveCategory(pc);
	}

}
