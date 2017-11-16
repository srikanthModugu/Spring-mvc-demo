package com.bridgeit.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.bridgeit.dao.UserDAO;
import com.bridgeit.model.Person;

public class UserDaoService  {
    
	@Autowired
	private UserDAO dao;

	public Boolean addPerson(Person person) {
		
		return dao.addPerson(person);
	}

	
	public Boolean authPerson(String email, String password) {
	
		return dao.authPerson(email, password);
	}

	
	public String authPerson(String email) {
		
		return dao.authPerson(email);
	}

}
