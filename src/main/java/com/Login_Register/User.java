package com.Login_Register;

public class User {
	String name;
	String password;
	String number;
	String email;
	public User() {
		
	}
	public User(String name, String password, String number, String email) {
		super();
		this.name = name;
		this.password = password;
		this.number = number;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
