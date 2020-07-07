package org.zerock.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
public class CommonController {
	@GetMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
		log.info("access Denied : " + auth);
		model.addAttribute("msg","접근권한 없음");
	}
	
	@GetMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		log.info("error: "+error);
		log.info("logout: "+logout);
		
		if(error!=null) {
			model.addAttribute("error","로그인에 실패하였습니다");
		}
		if(logout!=null) {
			model.addAttribute("logout","Logout!!");
		}
		
	}
	
	@GetMapping("/customLogout")
	public void logoutGet() {
		//csrf토큰 생성 후 세션변수에 저장하고, csrf토큰을 jsp페이지로 전달
		log.info("custom logout");
	}
	@PostMapping("/customLogout")
	public void logoutPost() {
		//jsp에서 넘어온 csrf토큰값과 세션변수의 토큰값이 일치하는지 검증
		log.info("custom logout");
	}
}
