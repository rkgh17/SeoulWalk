package com.human.seoulroad.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("user")
public class UserController {

	
	@GetMapping("login")
	public String login() {
		
		//model.addAttribute("posts", "");
		
		return "login";
	}

}
