package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demo.beans.BankInfo;

public class BankInfoDAO {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection connection;
	
	public BankInfoDAO(){
		
		this.jdbcURL = "jdbc:mysql://localhost:3306/projectdb";
        this.jdbcUsername = "root";
        this.jdbcPassword = "mysql";
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        
        try {
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int addBankInfo(BankInfo bankInfo) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement
					("insert into Bankinfo (bankname, account, ssn, personalId) values (?,?,?,?)");
			
			preparedStatement.setString(1, bankInfo.getBankname());
			preparedStatement.setString(2, bankInfo.getAccount());
			preparedStatement.setString(3, bankInfo.getSsn());
			preparedStatement.setInt(4, bankInfo.getPersonalInfoId());
			
			int rowsAdded = preparedStatement.executeUpdate();
			
			if(rowsAdded > 0) {
				return rowsAdded;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
