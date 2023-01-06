package com.human.seoulroad.othercourse;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OtherCourseController {
	
	private final OtherCourseService othercourseService;
	
	@RequestMapping("/home/other")
	public String other() {
		return "other";
	}
	
	// url의 파라미터를 받는 방법중의 하나 : @RequestParam
	// 변수명은 other.html의 name과 똑같이 맞춰줘야함
	// 각 변수명에는 value값이 들어옴
	// ex) 강남을 체크하고 검색을 보내면 addressKindU = a 이런 형식으로 값이 설정됨
	@GetMapping("/home/form-action")
	public String list( @RequestParam String addressKindU,
						@RequestParam String addressKindD,
						@RequestParam String distance,
						@RequestParam String duration,
						@RequestParam String difficulty,
						Model model) {
		
		
		
		// 값 검사하여 db에 전달
		if (addressKindU.equals("a")) { // 여명님이 강남은 value=a로 해놨으므로 문자열 a와 비교를 하였음
			
			// sql에 like 쿼리를 보내기위한 문자열을 새로 만듬 
			String todb = "강남";
			
			// othercourseService를 통해 othercourseRepository 접근
			List<OtherCourse> ocList = othercourseService.test(todb);
			
			// 결과를 모델에 담음
			model.addAttribute("ocList",ocList);
			
			return "other_course";
		}
		
		else { // 강북을 골랐을 시 그냥 전부를 보여주게 함 - 이전에 테스트용으로 완성시켜놨던 코드
			// test - select all
			List<OtherCourse> ocList = this.othercourseService.getList();
			model.addAttribute("ocList",ocList);
			return "other_course";
		}
	}
	
}
