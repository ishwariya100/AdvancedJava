package com.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.Listener.ContextListener;
import com.demo.bean.UserBean;

public class LoginDAO {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	
	/*
	public LoginDAO() {
		  this.jdbcURL = ContextListener.getJdbcURL();
	      this.jdbcUsername = ContextListener.getJdbcUsername();
	      this.jdbcPassword = ContextListener.getJdbcPassword();
    }*/
	
	public LoginDAO() {
        this.jdbcURL = System.getenv("JDBC_URL");
        this.jdbcUsername = System.getenv("JDBC_USERNAME");
        this.jdbcPassword = System.getenv("JDBC_PASSWORD");
    }
    
	public boolean validate(UserBean userbean) {   
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	    try {
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			PreparedStatement preparedStatement = connection.prepareStatement("select * from usersTable where username=? and password=?");
			preparedStatement.setString(1, userbean.getUsername());
			preparedStatement.setString(2, userbean.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			return resultSet.next();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
}
