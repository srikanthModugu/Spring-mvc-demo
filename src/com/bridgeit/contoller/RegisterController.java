package com.bridgeit.contoller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.dao.UserDAO;
import com.bridgeit.model.Login;
import com.bridgeit.model.Person;
import com.bridgeit.service.UserDaoService;
import com.bridgeit.utility.SendEmailUtility;

@Controller
public class RegisterController {

	@Autowired
	private UserDaoService service;

	@Autowired
	private SendEmailUtility email;

	@Autowired
	private Validator regValidate;

	@RequestMapping("/register")
	public String register(Model per) {
		Person s = new Person();

		per.addAttribute("person", s);

		return "register";
	}

	@RequestMapping("/regProcess")
	public ModelAndView regProcess(@ModelAttribute("person") Person per, BindingResult result) {
		ModelAndView mav = new ModelAndView("register");

		regValidate.validate(per, result);

		if (!result.hasErrors()) {
			String error = service.authPerson(per.getEmail());

			if (error.equalsIgnoreCase("sucess")) {
				if (service.addPerson(per)) {
					mav = new ModelAndView("login");
					email.sendEmail(per);
					mav.addObject("login", new Login());
					mav.addObject("mesg", "Registered SucessFully...");

					return mav;
				}

				mav.addObject("error", "something went wrong please try after some Time");

			}

			mav.addObject("error", error);

		}

		return mav;
	}

}
