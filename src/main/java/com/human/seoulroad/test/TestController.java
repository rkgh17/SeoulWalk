package com.human.seoulroad.test;

import java.util.List;

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
					 @RequestParam String q3,
					 @RequestParam String q4,
					 @RequestParam String q5,
					 @RequestParam String q6,
					 @RequestParam String q7,
					 @RequestParam String q8){

		
		

		if(q1.equals("T")) {
			model.addAttribute("q1","1번에 첫문항");
		}else {
			model.addAttribute("q1","1번에 두번째 문항");
		}
		
		
		model.addAttribute("q2", q2);
		model.addAttribute("q3", q3);
		
		return "test/testresult";
	}
	
	// 가중치 함수
	public String searchWeight(String q1,String q3,String q5,String q7) {
		int less = 3;
		int middle = 5;
		int high = 10;
		int[] weight = {0,0,0,0};
		
		//q1
		if(q1.equals("T")) {
			weight[0] = weight[0] + high;
			weight[1] = weight[1] + high;
			weight[2] = weight[2] + less;
		}else {
			weight[3] = weight[3] + high; 
		}
		
		//q3
		if(q3.equals("T")) {
			weight[0] = weight[0] + middle;
			weight[2] = weight[2] + high;
			weight[3] = weight[3] + middle;
		}else {
			weight[1] = weight[1] + high;
			weight[2] = weight[2] + less;
		}
		
		//q5
		if(q5.equals("T")) {
			weight[0] = weight[0] + middle;
			weight[1] = weight[1] + middle;
			weight[2] = weight[2] + less;
		}else {
			weight[3] = weight[3] + high;
		}	
		
		//q7
		if(q7.equals("F")) {
			weight[2] = weight[2] + high;
		}
		
		int[] max = {0};
		int maxindex = 0;
		for(int i = 0 ; i<weight.length ; i++) {
			if(weight[i] > max[0]) {
				max[0] = weight[i];
				maxindex = i;
			}
		}
		
		return null;
	}
}
