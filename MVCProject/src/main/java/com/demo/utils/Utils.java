package com.demo.utils;

import jakarta.servlet.http.HttpServletRequest;

public class Utils {

	public static String isPersonalInfoRegRequestParamsValid(HttpServletRequest request) {
		
		String firstname = request.getParameter("firstname");
		
		if(firstname == null || firstname.isEmpty())
				return "FIRSTNAME IS MANDATORY";
		else
			return null;
	}

	public static String isContactInfoRegRequestParamsValid(HttpServletRequest request) {
		
		String phone = request.getParameter("phone");
	
		if(phone == null || phone.isEmpty())
				return "PHONE IS MANDATORY";
		else
			return null;
	}
	
	public static String isBankInfoRegRequestParamsValid(HttpServletRequest request) {
		
		String ssn = request.getParameter("ssn");
	
		if(ssn == null || ssn.isEmpty())
				return "SSN IS MANDATORY";
		else
			return null;
	}
	
}
