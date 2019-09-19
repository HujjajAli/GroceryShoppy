package groceryshoppy.ogs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import groceryshoppy.ogs.dao.CostumerDAO;
import groceryshoppy.ogs.daoimplement.CostumerDaoImplement;
import groceryshoppy.ogs.entity.Costumer;

/**
 * Servlet implementation class CostumerCRUDController
 */
@WebServlet("/CostumerCRUDController")
public class CostumerCRUDController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CostumerDAO cdao = new CostumerDaoImplement();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CostumerCRUDController() {
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
		System.out.println("At Costumer Controller");
		Costumer cos = new Costumer();
		
		cos.setCosName(request.getParameter("name"));
		cos.setEmail(request.getParameter("email"));
		cos.setPassword(request.getParameter("password"));
		String conpass = request.getParameter("confirmPassword");
		
		System.out.println(cos.getCosName());
		System.out.println(cos.getEmail());
		System.out.println(cos.getPassword());
		System.out.println(conpass);
		
		cdao.saveCostumer(cos);
	}

}
