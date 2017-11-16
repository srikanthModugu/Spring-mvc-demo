package com.bridgeit.validation;



import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.bridgeit.model.Person;

public class RegisterValidator implements Validator {
	private final String emailRegex = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$";
	
	@Override
	public boolean supports(Class<?> arg0) {
	
		return false;
	}


	@Override
	public void validate(Object arg0, Errors errors) {
		Person per = (Person) arg0;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "register.email.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"passWord" , "register.password.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name" , "register.name.required");
		System.out.println(per+"  .....printing");
		
		if (!Pattern.matches(emailRegex, per.getEmail())) {
			errors.rejectValue("email","register.email.patren");
		}
		
		if(per.getPassWord().length()<=8 || per.getPassWord().length()>16){
			System.out.println("haiiii");
			errors.rejectValue("passWord","register.password.patren");
		}
		
		if(per.getName().length()<=8 || per.getName().length()>32){
			errors.rejectValue("name","register.name.patren");
		}
	 }
		
	}


