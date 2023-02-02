package com.human.seoulroad.user;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("user")
public class UserController {

	
	@GetMapping("login")
	public String login() {
		
		return "login";
	}
	
	@GetMapping("logout")
	public String logoutpage() {
		
		return "logout";
	}
	
	@GetMapping("logout/do")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
			return "redirect:/main";
	}

}
