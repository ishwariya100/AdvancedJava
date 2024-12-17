package com.demo.service;

import com.demo.beans.ContactInfo;
import com.demo.dao.ContactInfoDAO;

public class ContactInfoService {
	
private ContactInfoDAO contactInfoDAO = new ContactInfoDAO();
	
	public int registerContactInfo(ContactInfo contactInfo) {
		
		return contactInfoDAO.addContactInfo(contactInfo);
		
	}
	
}
