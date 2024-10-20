package com.demo.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.Beans.UserBean;

public class UserDAOImpl implements UserDAO {
	
	
	@Override
	public Boolean isUsernameTaken(UserBean userBean) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancedjavatraining", "root", "mysql");
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
		
		String error = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancedjavatraining", "root", "mysql");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into userdata values (?,?,?,?)");
			preparedStatement.setString(1, userBean.getFirstname());
			preparedStatement.setString(2, userBean.getLastname());
			preparedStatement.setString(3, userBean.getUsername());
			preparedStatement.setString(4, userBean.getPassword());
			
			int result = preparedStatement.executeUpdate();
			if(result < 0)
				error = "Error while registering user to DB";
			
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
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancedjavatraining", "root", "mysql");
			PreparedStatement preparedStatement = connection.prepareStatement("select * from userdata where username=? and password=?");
			preparedStatement.setString(1, userBean.getUsername());
			preparedStatement.setString(2, userBean.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {		
				userBean.setFirstname(resultSet.getString("firstname"));				
				userBean.setLastname(resultSet.getString("lastname"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userBean;
	}

}
