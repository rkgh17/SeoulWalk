package com.human.seoulroad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String root() {
		return "redirect:/home";
	}
	@RequestMapping("/AAA")
	public String AAA() {
		return "AAA";
	}
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/introduce")
	public String introduce() {
		return "introduce";
	}

	
}
