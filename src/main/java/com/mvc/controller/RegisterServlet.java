package com.mvc.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RegisterServlet extends HttpServlet {
	
	

    private User model;

    @Override
    public void init() {
        model = new User(null, null, null, null, null, null);
    }
	
	
	
	private static final long serialVersionUID = 1L;
       
    
    public RegisterServlet() {
        super();
      
    }
    
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    }
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
	    String password = request.getParameter("password");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String company = request.getParameter("company");
	    String adresse = request.getParameter("adresse");
	    User user = new User(username, password, email, phone, company, adresse);
	    model.addUser(user);
	  
        
	
	    // Connect to the database
	   
	    Connection conn = null;
	    
	    
	    try {
	      // Load the JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	      // Connect to the database
	      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "amine15987");
	      conn.setAutoCommit(false);
	      // Create a statement
	      Statement stmt = conn.createStatement();
	      // Insert the data into the database*
	      
	       
		stmt.executeQuery("INSERT INTO user (username, password, email, phone, company, adresse) VALUES ('" + username + "', '"
		+ password + "', '" + email + "'"
		+ ", '" + phone + "' , '" + company + "' , '" + adresse + "' )");
		
		
		
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    } finally {
	      // Close the connection
	      if (conn != null) {
	        try {
	          conn.close();
	        } catch (SQLException e) {
	                 
	          
	        }
	      }
	      response.sendRedirect("success.html");
	    }
	    
	    doGet(request, response);
		
	    
	}


	


}
