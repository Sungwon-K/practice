package com.codingclass.service;

import java.util.List;

import com.codingclass.domain.ClassesVO;

public interface StudyManagerService {
	
	/*
	 *작성자 : 김성원
	 *메소드명 : getList
	 *기능 : 클래스 리스트 검색
	 */
	public List<ClassesVO> getList();
}
