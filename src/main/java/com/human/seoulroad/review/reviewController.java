package com.human.seoulroad.review;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/recommendcourse")
@RequiredArgsConstructor
@Controller
public class reviewController {
	
	private final reviewService reviewService;

    @GetMapping("/couple")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<review> paging = this.reviewService.getList(page);
        model.addAttribute("paging", paging);
        return "rcmCouple";
    }
    @GetMapping("/create")
    public String reivewCreate(reviewForm reviewForm) {
        return "reviewForm";
    }
    

    @PostMapping("/create")
    public String reviewCreate(@Valid reviewForm reviewForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reviewform";
        }
    	this.reviewService.create(reviewForm.getReviewStar(), reviewForm.getId(), reviewForm.getReviewContents());
        return "redirect:/recommendcourse/couple"; 
    }
    
}