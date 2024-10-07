package com.learning.demo;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataInsertionServlet
 */

@WebServlet("/addUserServlet")
public class AddUserServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Connection connection = null;
	
	public void init(ServletConfig config) throws ServletException {

		try {

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/advancedjavatraining",
					"root", "mysql");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void destroy() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("FirstName");
		String lastName = request.getParameter("LastName");
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PERSONS (firstname, lastname) VALUES (?,?)");
			preparedStatement.setString(1, firstName);
			preparedStatement.setString(2, lastName);
			int result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				response.sendRedirect("Success.html");
			}else {
				System.out.println("Failed to add user to Database");
				request.getRequestDispatcher("AddUser.html").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
