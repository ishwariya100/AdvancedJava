package com.learning.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbctraining {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancedjavatraining", "root", "mysql");
				Statement statement = connection.createStatement();
				statement.executeUpdate("insert into persons (personId, firstname, lastname) values (2, 'Ish', 'Ganesh')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		
		
	}

}
