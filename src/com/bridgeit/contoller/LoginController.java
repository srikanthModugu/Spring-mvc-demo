package com.bridgeit.contoller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.Login;
import com.bridgeit.service.UserDaoService;



@Controller
public class LoginController {

	@Autowired
	private UserDaoService service;
    
	@Autowired
	private Validator logValidate;
	
	@RequestMapping("/login")
	public String showLoginPage(Model model) {
		Login login = new Login();
		model.addAttribute("login", login);
		return "login";
	}

	@RequestMapping("/loginProcess")
	public ModelAndView userLogin(@ModelAttribute("login") Login login,HttpServletRequest request,BindingResult result) {
	    ModelAndView mav = new ModelAndView("login");
	    
		logValidate.validate(login,result );
		
		if(!result.hasErrors())
		{
			if(service.authPerson(login.getEmail(), login.getPassword()))
			{
				mav = new ModelAndView("sucess");
				mav.addObject("email", login.getEmail());
				HttpSession session = request.getSession(true);
				session.setAttribute("email", login.getEmail());
				return mav;
			}
			mav.addObject("error", "invalid  Email or password");
			return mav;
		}
		return mav;
	}
}
