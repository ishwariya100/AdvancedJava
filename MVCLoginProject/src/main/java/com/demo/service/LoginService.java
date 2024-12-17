package com.demo.service;

import com.demo.DAO.LoginDAO;
import com.demo.bean.UserBean;

public class LoginService {
	
	private LoginDAO loginDAO = new LoginDAO();
	public String authenticateUser(UserBean userbean) {
		
		String error = null;
		if(!loginDAO.validate(userbean)) {
			error = "Invalid Credentials";
		}
		return error;
	}
	
	

}
