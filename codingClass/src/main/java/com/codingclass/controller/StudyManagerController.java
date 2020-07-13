package com.codingclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingclass.service.StudyManagerService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/studyManager/*")
@AllArgsConstructor
public class StudyManagerController {

	private StudyManagerService service;
	
	@GetMapping("/classList")
	public void classList(Model model) {
		log.info("classList");
		model.addAttribute("list",service.getList());
	}
	
	@GetMapping("/classManage")
	public void classManage() {
	}
	
	@GetMapping("/studentShow")
	public void studentShow() {
	}
	
	//전체 수강생 클래스 리스트
	@GetMapping("/classUserList")
	public void classUserList() {
	}
}
