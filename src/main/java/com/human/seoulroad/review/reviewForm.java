package com.human.seoulroad.review;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class reviewForm {
	@NotEmpty(message="닉네임을 입력해주세요.")
	@Size(max=10)
	private String id;
	
	@NotEmpty(message="내용을 입력해주세요.")
	@Size(max=100)
	private String reviewContents;
	
	@NotEmpty(message="별점을 선택해주세요.")
	private String reviewStar;
}
