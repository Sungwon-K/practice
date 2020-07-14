package com.codingclass.mapper;

import java.util.List;

import com.codingclass.domain.ClassesVO;

public interface StudyManagerMapper {
	
	/*
	 *작성자 : 김성원
	 *메소드명 : getList
	 *기능 : 클래스 리스트 검색
	 */
	public List<ClassesVO> getList();
	
	/*
	 *작성자 : 김성원
	 *메소드명 : classInsert
	 *기능 : 클래스 테이블에 정보입력
	 */
	public void classInsert(ClassesVO classes);
}
