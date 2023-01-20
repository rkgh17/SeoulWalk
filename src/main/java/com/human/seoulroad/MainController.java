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
//	@RequestMapping("/AAA2")
//	public String AAA2() {
//		return "AAA2";
//	}
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/introduce")
	public String introduce() {
		return "introduce";
	}
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	
}
