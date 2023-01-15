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

/**
 * Servlet implementation class RegisterServlet
 */
public class ContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactServlet() {
        super();
      
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
	    String email = request.getParameter("email");
	    String phone = request.getParameter("phone");
	    String company = request.getParameter("company");
	    String message = request.getParameter("message");
	    
	    
	   
	    
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
	      
	       
		stmt.executeQuery("INSERT INTO Contact (username, password, email, phone, company, adresse) VALUES ('" + name + "', '" + email + "'"
		+ ", '" + phone + "' , '" + company + "' '"+ message +"')");
		
		
		
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
	      response.sendRedirect("contact.html");
	    }
	    
	    doGet(request, response);
		
	    
	}


	


}
