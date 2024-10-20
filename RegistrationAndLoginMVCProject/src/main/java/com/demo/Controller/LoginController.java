package com.demo.Controller;

import java.io.IOException;

import com.demo.Beans.UserBean;
import com.demo.Service.LoginService;
import com.demo.Utils.UserUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/loginController")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public LoginController() {
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBean userBean = new UserBean();
		LoginService loginService = new LoginService();
	    
		userBean.setUsername(request.getParameter("username"));
		userBean.setPassword(request.getParameter("password"));
		
		String error = UserUtils.validateLoginUser(userBean);
		
		if(error == null) {		
			
			userBean = loginService.authenticateAndGetUser(userBean);
			
			if((userBean.getFirstname()!= null && userBean.getLastname()!= null)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", userBean.getUsername());
				response.sendRedirect("Success.jsp");
				return;
			}	
			else {
				error = "username or password invalid";
			}
		}
		
		request.setAttribute("error", error);
		request.getRequestDispatcher("Login.jsp").forward(request, response);
	}

}
