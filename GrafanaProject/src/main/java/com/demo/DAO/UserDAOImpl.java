package com.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.Beans.UserBean;
import com.demo.Listener.ContextListener;

public class UserDAOImpl implements UserDAO {
	
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	
	public UserDAOImpl() {
		System.out.println(ContextListener.getJdbcURL());
		this.jdbcURL = ContextListener.getJdbcURL();
		System.out.println("jdbcURL is set");
	      this.jdbcUsername = ContextListener.getJdbcUsername();
	      this.jdbcPassword = ContextListener.getJdbcPassword();
    }
	
	@Override
	public Boolean isUsernameTaken(UserBean userBean) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("before getting connection");
			System.out.println(jdbcUsername);
			System.out.println("after printing ");
			System.out.println(jdbcURL);
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			PreparedStatement preparedStatement = connection.prepareStatement("select * from userdata where username=?");
			preparedStatement.setString(1, userBean.getUsername());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public String addUser(UserBean userBean) {
		
		System.out.println("Inside addUser class");
		String error = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println("Inside try block");
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			System.out.println("Before making prepare statement");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into userdata (firstname, lastname, username, password) values (?,?,?,?)");
			System.out.println("After making prepare statement");
			preparedStatement.setString(1, userBean.getFirstname());
			preparedStatement.setString(2, userBean.getLastname());
			preparedStatement.setString(3, userBean.getUsername());
			preparedStatement.setString(4, userBean.getPassword());
			
			int result = preparedStatement.executeUpdate();
			if(result < 0) {
				System.out.println("setting error in dao class");
				error = "Error while registering user to DB";
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return error;
	}

	@Override
	public UserBean checkAndReturnUser(UserBean userBean) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			System.out.println(userBean.getUsername());
			System.out.println(userBean.getPassword());
			Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			PreparedStatement preparedStatement = connection.prepareStatement("select * from userdata where username=? and password=?");
			preparedStatement.setString(1, userBean.getUsername());
			preparedStatement.setString(2, userBean.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {	
				System.out.println("Inside if loop");
				System.out.println(resultSet.getString("firstname"));
				System.out.println(resultSet.getString("lastname"));
				userBean.setFirstname(resultSet.getString("firstname"));				
				userBean.setLastname(resultSet.getString("lastname"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userBean;
	}

}
