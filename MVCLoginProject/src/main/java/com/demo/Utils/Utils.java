package com.demo.Utils;

import jakarta.servlet.http.HttpServletRequest;

public class Utils {

	public static String validateRequest(HttpServletRequest request) {
		
		String error = null;
		if(request.getParameter("username").isEmpty() || request.getParameter("password").isEmpty()) {
			error = "Invalid Inputs";
		}
			
		return error;
		
	}
	
	
}
