package com.human.seoulroad.rcmcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/recommendcourse")
@Controller
public class RcmCourseController {
	
	@RequestMapping("")
	public String rcmcourse() {
		return "rcmcourse";
	}	
	
	@RequestMapping("/family")
	public String family() {
		return "rcmFamily";
	}
	
//	@RequestMapping("/couple")
//	public String couple() {
//		return "rcmCouple";
//	}
	
	@RequestMapping("/restaurant")
	public String restaurant() {
		return "rcmRestaurant";
	}
	
	@RequestMapping("/nature")
	public String nature() {
		return "rcmNature";
	}
}
