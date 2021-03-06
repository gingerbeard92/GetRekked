package edu.scranton.getrekked.shared;

import java.io.Serializable;


public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String first_name;
	private String last_name;
	private String email;
	private String date_of_birth;
	private char gender;
	private String phone_number;
	private String address;
	
	public User(){
		
	}
	public User(String username, String pass) {
		super();
		this.username = username;
		this.password = pass;
		/*this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.date_of_birth = date_of_birth;
		this.gender = gender;
		this.phone_number = phone_number;
		this.address = address;*/
	}

	public String getUserName() {
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

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
