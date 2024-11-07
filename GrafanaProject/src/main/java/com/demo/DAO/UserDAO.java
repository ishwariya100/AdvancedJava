package com.demo.DAO;

import com.demo.Beans.UserBean;

public interface UserDAO {

	Boolean isUsernameTaken(UserBean userBean);

	String addUser(UserBean userBean);
	
	UserBean checkAndReturnUser(UserBean userBean);

}
