package com.bridgeit.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForgetPasswordController {
    
	@RequestMapping("/forgot")
	public String showForget()
	{
		return "forGotPass";
	}
}
