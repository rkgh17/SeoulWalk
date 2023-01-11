package com.human.seoulroad.answer;

import java.security.Principal;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.human.seoulroad.question.Question;
import com.human.seoulroad.question.QuestionService;
import com.human.seoulroad.user.CustomOAuth2UserService;
import com.human.seoulroad.user.SiteUser;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/answer") // URL 프리픽스
@RequiredArgsConstructor
@Controller
public class AnswerController {
	
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final CustomOAuth2UserService userService;

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/create/{id}") // post요청만 받아들일 경우에 사용하는 에너테이션. (value=) 생략가능
    public String createAnswer(Model model, @PathVariable("id") Integer id,
    						   @Valid AnswerForm answerForm, 
    						   BindingResult bindingResult, 
    						   Principal principal) {
        Question question = this.questionService.getQuestion(id);
        
        // 글쓴이 속성
        SiteUser siteUser = this.userService.getUser(principal.getName());
        
    	// 검증 실패시 다시 리턴
        if (bindingResult.hasErrors()) {
            model.addAttribute("question", question);
            return "bbs/bbsQnaDetail";
        }
        
        // 답변저장 - 답변 객체
        Answer answer = this.answerService.create(question, 
        		answerForm.getContent(), 
        		siteUser);
        
        // 답변 작성 후 앵커로 돌아감
        return String.format("redirect:/question/detail/%s#answer_%s", 
        		answer.getQuestion().getId(), 
        		answer.getId());
    }
	
}
