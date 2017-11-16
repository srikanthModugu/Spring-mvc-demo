package com.bridgeit.model;



public class Person {
	
	
	private String name;
	

	private String email;
	
	
	private String passWord;
	
	
	private String gender;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassWord() {
		return passWord;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", email=" + email + ", passWord=" + passWord + ", gender=" + gender + "]";
	}
	
	
	
	
}
