package groceryshoppy.ogs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import groceryshoppy.ogs.dao.AdminDAO;
import groceryshoppy.ogs.daoimplement.AdminDaoImplement;
import groceryshoppy.ogs.entity.Admin;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AdminDAO ad = new AdminDaoImplement();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpSession ses = request.getSession();
		
		int v = ad.validateAdmin(username, password);
		System.out.println("V = "+v);
		if(v == 0){
			System.out.println("Admin is Not Valid");
		}else if(v == 1){
			Admin admin= ad.getAdminByUsername(username);
			System.out.println("Admin "+admin.getUsername());
			ses.setAttribute("adminemail", admin.getUsername());
			ses.setAttribute("loginadminses", admin);
			request.getRequestDispatcher("adminIndexPage.jsp").forward(request, response);
		}else if(v == 2){
			//System.out.println("Admin "+admin.getUsername());
			System.out.println("No Admin Data");
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		}
		
		System.out.println("Kam OK Ahi Admin");
	}

}
