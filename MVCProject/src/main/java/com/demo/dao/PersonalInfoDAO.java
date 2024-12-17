package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.PersonalInfo;

public class PersonalInfoDAO {

	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	private Connection connection;
	
	public PersonalInfoDAO() {
		
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
	
	public int addPersonalInfo(PersonalInfo personalInfo) {
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into personalinfo (firstname, lastname, middlename, gender) values (?,?,?,?)");
			preparedStatement.setString(1, personalInfo.getFirstname());
			preparedStatement.setString(2, personalInfo.getLastname());
			preparedStatement.setString(3, personalInfo.getMiddlename());
			preparedStatement.setString(4, personalInfo.getGender());
			int rowsAdded = preparedStatement.executeUpdate();
			
			if(rowsAdded == 1) {
				
				String selectSQL = "SELECT LAST_INSERT_ID()";
				PreparedStatement selectStmt = connection.prepareStatement(selectSQL);

				ResultSet rs = selectStmt.executeQuery();
				if (rs.next()) {
				    int generatedId = rs.getInt(1); // Retrieve the generated ID
				    return generatedId;
				}				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

}
