package com.codingclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingclass.domain.ClassesVO;
import com.codingclass.service.StudyManagerService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/studyManager/*")
@AllArgsConstructor
public class StudyManagerController {

	private StudyManagerService service;
	
	/*
	 *작성자 : 김성원
	 *메소드명 : classList
	 *기능 : studyManagerService의 getList로 불러온 정보를 list에 담고 classList페이지 이동 
	 */
	@GetMapping("/classList")
	public void classList(Model model) {
		log.info("classList");
		model.addAttribute("list",service.getList());
	}
	
	/*
	 *작성자 : 김성원
	 *메소드명 : classManage(get)
	 *기능 :
	 *1.request받은 classNo를 studyManagerService의 get메소드에게 전달한다.
	 *2.get메소드로 불러온 정보를 class에 담고 classManage페이지 이동 
	 */
	@GetMapping("/classManage")
	public void classManage(@RequestParam("classNo") Long classNo, Model model) {
		
		log.info("/classManage");
		model.addAttribute("class",service.get(classNo));
	}
	
	/*
	 *작성자 : 김성원
	 *메소드명 : classModify
	 *기능 :
	 *1.studyManagerService의 modify메소드에게 classes정보를 전달한다.
	 *2.수정사항이 있으면 result에 success를 포장한다.('#번 수정 완료했습니다.'처리를 위해)
	 *3.모든 처리 후 classList로 이동한다. 
	 */	
	@PostMapping("/classModify")
	public String classManage(ClassesVO classes, RedirectAttributes rttr) {
		
		log.info("modify :" + classes);
		
		if(service.modify(classes)) {
			rttr.addFlashAttribute("result","success");
		}		
		return "redirect:/studyManager/classList";
	}
	
	/*
	 *작성자 : 김성원
	 *메소드명 : classRegisert(get)
	 *기능 : classRegister로 이동 
	 */
	@GetMapping("/classRegister")
	public void classRegister() {
	}
	
	/*
	 *작성자 : 김성원
	 *메소드명 : classRegisert(post)
	 *기능 : 
	 *1.studyManagerService의 register메소드에게 classes정보를 전달한다.
	 *2.해당 클래스의 classNo를 result로 포장한다.('#번 입력 완료했습니다.'처리를 위해)
	 *3.모든 처리 후 classList로 이동한다. 
	 */
	@PostMapping("/classRegister")
	public String classRegister(ClassesVO classes, RedirectAttributes rttr) {		
		log.info("register: " + classes);		
		service.register(classes);		
		rttr.addFlashAttribute("result", classes.getClassNo());		
		return "redirect:/studyManager/classList";
	}
	
	/*
	 *작성자 : 김성원
	 *메소드명 : studentRemove
	 *기능 :
	 *1.studyManagerService의 remove메소드에게 classNo정보를 전달한다.
	 *2.수정사항이 있으면 result에 success를 포장한다.('#번 삭제 완료했습니다.'처리를 위해)
	 *3.모든 처리 후 classList로 이동한다. 
	 */
	@PostMapping("/classRemove")
	public String classRemove(@RequestParam("classNo") Long classNo, RedirectAttributes rttr) {
		log.info("remove :" + classNo);
		
		if(service.remove(classNo)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/studyManager/classList";
	}
	
	/*
	 *작성자 : 김성원
	 *메소드명 : studentShow
	 *기능 : studentShow로 이동 
	 */
	@GetMapping("/studentShow")
	public void studentShow() {
	}	
	
}
