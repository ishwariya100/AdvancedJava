package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demo.beans.ContactInfo;

public class ContactInfoDAO {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection connection;
	
	public ContactInfoDAO(){
		
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
	
	public int addContactInfo(ContactInfo contactInfo) {

		try {
			PreparedStatement preparedStatement = connection.prepareStatement
					("insert into contactinfo (address, city, state, country, phone, personalId) values (?,?,?,?,?,?)");
			
			preparedStatement.setString(1, contactInfo.getAddress());
			preparedStatement.setString(2, contactInfo.getCity());
			preparedStatement.setString(3, contactInfo.getState());
			preparedStatement.setString(4, contactInfo.getCountry());
			preparedStatement.setString(5, contactInfo.getPhone());
			preparedStatement.setInt(6, contactInfo.getPersonalInfoId());
			
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


