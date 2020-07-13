package com.codingclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingclass.domain.UsersVO;
import com.codingclass.service.AuthAddService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@AllArgsConstructor
public class AuthAddController {
	
	private AuthAddService service;
	
	@GetMapping("/authAdd")
	public void authAdd() {
	}
	
	@PostMapping("/authAdd")
	public String authAdd(UsersVO board, RedirectAttributes rttr) {
		log.info("MemberVo = " + board);
		
		service.authAdd(board);
		rttr.addFlashAttribute("result", board.getUserNo());
		
		return "redirect:/";
	}
}
