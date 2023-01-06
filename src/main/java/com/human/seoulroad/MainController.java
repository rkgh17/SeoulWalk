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
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/home/introduce")
	public String introduce() {
		return "introduce";
	}

//	@RequestMapping("/home/other")
//	public String other() {
//		return "other";
//	}

	/*
	 * @GetMapping(value = {"/home/no",
	 * "/home/form-action.html?addressKindU=강북권%2F강남권+선택&addressKindD=선택해주세요."})
	 * public String other_course() { return "other_course"; }
	 */
	

	
//	@GetMapping("/home/other?addressKindU=a&addressKindD=노원구&distance=5between10&duration=2under&difficulty=normal")
//	public String other_course() {
//		return "other_course";
//	}

	@RequestMapping("/recommendcourse")
	public String rcmcourse() {
		return "rcmcourse";
	}
	

}
