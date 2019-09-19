package groceryshoppy.ogs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import groceryshoppy.ogs.dao.CostumerDAO;
import groceryshoppy.ogs.daoimplement.CostumerDaoImplement;
import groceryshoppy.ogs.entity.Costumer;

/**
 * Servlet implementation class CostumerLoginController
 */
@WebServlet("/CostumerLoginController")
public class CostumerLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	CostumerDAO cdao = new CostumerDaoImplement();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CostumerLoginController() {
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
		String username = request.getParameter("Name");
		String password = request.getParameter("password");
		
		HttpSession ses = request.getSession();
		
		int v = cdao.validateCostumer(username, password);
		
		if(v == 0){
			System.out.println("User is Not Valid");
		}else if(v == 1){
			 Costumer costumer = cdao.getCostumerByUsername(username);
			 request.getSession().setAttribute("useremail", costumer.getEmail());
			 ses.setAttribute("loginses", costumer);
			 request.getRequestDispatcher("index.jsp").forward(request, response);
		}else if(v == 2){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		System.out.println("Kam OK Ahi");
		
	}

}
