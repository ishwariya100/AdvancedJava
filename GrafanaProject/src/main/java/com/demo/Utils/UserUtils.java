package com.demo.Utils;

import com.demo.Beans.UserBean;

public class UserUtils {
	
	public static String validateUser(UserBean userBean) {
		
		String Error = null;
		
		if((userBean.getFirstname().isEmpty()) || (userBean.getLastname().isEmpty()) || 
				userBean.getUsername().isEmpty() || userBean.getPassword().isEmpty()) {
			Error = "MISSING ERQUIRED FIELDS";
		}
		return Error;
	}
	
	public static String validateLoginUser(UserBean userBean) {
		
		String Error = null;
		
		if(userBean.getUsername().isEmpty() || userBean.getPassword().isEmpty()) {
			Error = "MISSING ERQUIRED FIELDS";
		}
		return Error;
	}
}
