package com.mvc.controller;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String email;
    private String phone;
    private String company;
    private String adresse;
	private List<User> users;

    

	public User(String username, String password, String email, String phone, String company, String adresse) {
		this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.company = company;
        this.adresse = adresse;
        users = new ArrayList<User>();
	}
	
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}



	public void addUser(User user) {
		
	        users.add(user);
	   
	}

	
		
		
}

    

