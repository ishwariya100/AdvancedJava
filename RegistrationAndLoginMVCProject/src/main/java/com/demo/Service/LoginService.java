package com.demo.Service;

import com.demo.Beans.UserBean;
import com.demo.DAO.UserDAO;
import com.demo.DAO.UserDAOImpl;

public class LoginService {
	
	private UserDAO userDao = new UserDAOImpl();
	
	public UserBean authenticateAndGetUser(UserBean userBean) {
		
		return userDao.checkAndReturnUser(userBean);
}
}
