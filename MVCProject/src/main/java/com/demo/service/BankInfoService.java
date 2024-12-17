package com.demo.service;

import com.demo.beans.BankInfo;
import com.demo.dao.BankInfoDAO;

public class BankInfoService {

	
private BankInfoDAO BankInfoDAO = new BankInfoDAO();
	
	public int registerBankInfo(BankInfo BankInfo) {
		
		return BankInfoDAO.addBankInfo(BankInfo);
		
	}
	
}
