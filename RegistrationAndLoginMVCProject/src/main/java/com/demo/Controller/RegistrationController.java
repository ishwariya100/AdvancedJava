package com.demo.Controller;

import java.io.IOException;

import com.demo.Beans.UserBean;
import com.demo.Service.RegistrationService;
import com.demo.Utils.UserUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registrationController")
public class RegistrationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
    public RegistrationController() {
        
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserBean userBean = new UserBean();
		RegistrationService registrationService = new RegistrationService();

		userBean.setFirstname(request.getParameter("firstname"));
		userBean.setLastname(request.getParameter("lastname"));
		userBean.setUsername(request.getParameter("username"));
		userBean.setPassword(request.getParameter("password"));
		
		String error = UserUtils.validateUser(userBean);
		
		if(error == null) {			
			error = registrationService.registerUser(userBean);
			if(error == null) {
				response.sendRedirect("Login.jsp");
				return;
			}				
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("error", error);
		response.sendRedirect("Registration.jsp");

	}

}
