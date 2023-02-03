package com.human.seoulroad.user;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("user")
public class UserController {

	
	@GetMapping("login")
	public String login(HttpServletRequest request) {
		/* 로그인 성공 시 이전 페이지로 이동 */
		// 이전 페이지의 uri저장
		String uri = request.getHeader("Referer"); // redirect하면 배포서버에서 null값 찍힘! -> redirect를 하면 안된다?
		System.out.println(uri + " - 첫번째 url");
		
		// redirect시
		if (uri==null) {
			Map<String, ?> paramMap = RequestContextUtils.getInputFlashMap(request);
			uri = (String) paramMap.get("referer");
			System.out.println(uri + " - 두번째 url"); // 성공.
		}
		
		request.getSession().setAttribute("prevPage", uri);
		
		return "login";
	}
	
	@GetMapping("logout")
	public String logoutpage() {
		
		return "logout";
	}
	
	@GetMapping("logout/do")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
			return "redirect:/main";
	}

}
