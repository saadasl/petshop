package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
 
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
		

	       
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        

	        // Connect to the database
	        Connection connection = null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase" , "root" , "amine15987");
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    
	        try {
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery(
	                "SELECT username, password FROM users WHERE username = '" + username + "', '"+ password +"'");
	            if (resultSet.next()) {
	                String dbUsername = resultSet.getString("username");
	                String dbPassword = resultSet.getString("password");
	                if (dbUsername.equals(username) && dbPassword.equals(password)) {
	                    
	                    response.sendRedirect("index.html");
	                    System.out.println("Login succesful");
	                } else {
	                   
	                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid username or password");
	                }
	            } else {
	              
	                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "username does not exist");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    
		
		
		
		doGet(request, response);
	}

}
