package com.bridgeit.contoller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.Login;

@Controller
public class LogoutController {
  
	@RequestMapping("/logout")
	public ModelAndView userLogout(HttpServletRequest request){
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("login", new Login());
		mav.addObject("mesg", "you're Logged Out");
		request.getSession(false).invalidate();
		return mav;
	}
}
