package com.demo.Service;

import com.demo.Beans.UserBean;
import com.demo.DAO.UserDAO;
import com.demo.DAO.UserDAOImpl;

public class RegistrationService {
	
	private UserDAO userDAO = new UserDAOImpl();
	
	public String registerUser(UserBean userBean) {
		
		String error = null;
		
		if(userDAO.isUsernameTaken(userBean)) {
			 error = "Username already exists"; 
		}
		else {
			error = userDAO.addUser(userBean);
			System.out.println("printing error in RegistrationService class");
			System.out.println(error);
		}		
		return error;
	}
	
	
}
