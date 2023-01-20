package com.human.seoulroad.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	@GetMapping("/roadtest")
	public String roadTest() {
		return "test/test";
	}

	@GetMapping("/roadtest/start")
	public String ts() {
		return "test/teststart";
	}
	
	@PostMapping("/test-form")
	public String tr(Model model,
					 @RequestParam String q1,
					 @RequestParam String q2,
					 @RequestParam String q3){

		if(q1.equals("T")) {
			model.addAttribute("q1","1번에 첫문항");
		}else {
			model.addAttribute("q1","1번에 두번째 문항");
		}
		
		
		model.addAttribute("q2", q2);
		model.addAttribute("q3", q3);
		
		return "test/testresult";
	}
}
