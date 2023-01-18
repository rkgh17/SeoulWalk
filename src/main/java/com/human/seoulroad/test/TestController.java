package com.human.seoulroad.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
