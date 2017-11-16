package com.bridgeit.validation;



import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bridgeit.model.Login;

public class LoginValidator implements Validator {
private final String emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
	
	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void validate(Object arg0, Errors errors) 
	{
		Login user = (Login) arg0;
	 	ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "login.email.required");
	 	if (!Pattern.matches(emailRegex, user.getEmail()) && errors.getErrorCount()==0) {
			errors.rejectValue("email","login.email.patren");
		}
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password" , "login.password.required");
		System.out.println(user+"  .....printing");
		System.out.println(errors.getErrorCount());
		
		
		if((user.getPassword().length()<=8 || user.getPassword().length()>16)){
			System.out.println("haiiii");
			errors.rejectValue("password","login.password.patren");
		}
		System.out.println(errors.getErrorCount());
	 }
		
	}


