package com.bridgeit.dao;

import com.bridgeit.model.Person;

public interface UserDAO {

	
	public Boolean addPerson(Person person);
	public Boolean authPerson(String email, String password);
	public String authPerson(String email);
}
