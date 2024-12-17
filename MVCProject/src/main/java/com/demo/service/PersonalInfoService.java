package com.demo.service;

import com.demo.beans.PersonalInfo;
import com.demo.dao.PersonalInfoDAO;

import jakarta.servlet.http.HttpServletRequest;

public class PersonalInfoService {
	
	private PersonalInfoDAO personalInfoDAO = new PersonalInfoDAO();
	
	public int registerPersonalInfo(PersonalInfo personalInfo) {
		
		return personalInfoDAO.addPersonalInfo(personalInfo);
		
	}
	
	
}
