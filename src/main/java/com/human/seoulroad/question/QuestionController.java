package com.human.seoulroad.question;

import java.security.Principal;

import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.human.seoulroad.answer.AnswerForm;
import com.human.seoulroad.user.CustomOAuth2UserService;
import com.human.seoulroad.user.SiteUser;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("board")
@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	private final CustomOAuth2UserService userService;
	
	@RequestMapping("notice")
	public String notice() {
		return "bbs/bbsNotice";
	}
	
	// qna 페이지 매핑
	@GetMapping("qna")
	public String qna(Model model,
			@RequestParam(value="page", defaultValue="0") int page,
			@RequestParam(value="kw", defaultValue="") String kw) {
		
		Page<Question> paging = this.questionService.getList(page, kw);
		model.addAttribute("paging",paging);
		model.addAttribute("kw", kw);
		
		return "bbs/bbsQna";
	}
	
	
	// 질문 상세 페이지 매핑
	@RequestMapping(value = "qna/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id,
			AnswerForm answerForm) {
		
		// 서비스를 통해 객체를 가져와 템플릿에 전달
		Question question = this.questionService.getQuestion(id);
		model.addAttribute("question", question);
		
		return "bbs/bbsQnaDetail";
	}
	
	@PreAuthorize("isAuthenticated()") // 로그인 필요
	@GetMapping("qna/create")
	public String questionCreate(QuestionForm questionForm) {
        return "home";
    }
	
	// 질문 등록 페이지 매핑
	@PreAuthorize("isAuthenticated()") // 로그인 필요
	@PostMapping("qna/create")
	// 제목, 내용, 작성자를 파라미터로 받음
	public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult, Principal principal) {
        if (bindingResult.hasErrors()) {
            return "bbs/bbsQnaForm";
        }
        SiteUser siteUser = this.userService.getUser(principal.getName());
        this.questionService.create(questionForm.getSubject(), questionForm.getContent(), siteUser);
        return "redirect:bbs/bbsQna";
    }

}
