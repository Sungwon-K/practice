package com.codingclass.service;

import java.util.List;

import com.codingclass.domain.ClassesVO;

public interface StudyManagerService {
	
	/*
	 *작성자 : 김성원
	 *메소드명 : register
	 *기능 : 클래스 정보 입력
	 */
	public void register(ClassesVO classes);
	
	/*
	 *작성자 : 김성원
	 *메소드명 : get
	 *기능 : 클래스 정보 한건 검색
	 */
	public ClassesVO get(Long classNo);
	
	/*
	 *작성자 : 김성원
	 *메소드명 : modify
	 *기능 : 클래스 정보 수정
	 */
	public boolean modify(ClassesVO classes);
	
	/*
	 *작성자 : 김성원
	 *메소드명 : remove
	 *기능 : 클래스 정보 삭제
	 */
	public boolean remove(Long classNo);
	
	/*
	 *작성자 : 김성원
	 *메소드명 : getList
	 *기능 : 클래스 리스트 검색
	 */
	public List<ClassesVO> getList();
	
}
