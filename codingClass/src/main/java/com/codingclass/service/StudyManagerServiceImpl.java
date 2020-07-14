package com.codingclass.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingclass.domain.ClassesVO;
import com.codingclass.mapper.StudyManagerMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
@AllArgsConstructor
public class StudyManagerServiceImpl implements StudyManagerService{

	private StudyManagerMapper mapper;	
	
	/*
	 *작성자 : 김성원
	 *메소드명 : register
	 *기능 : 클래스 정보 입력
	 */
	@Override
	public void register(ClassesVO classes) {
		log.info("regisert :" + classes);
		mapper.classInsert(classes);		
	}
	
	/*
	 *작성자 : 김성원
	 *메소드명 : get
	 *기능 : 클래스 정보 한건 검색
	 */
	@Override
	public ClassesVO get(Long classNo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*
	 *작성자 : 김성원
	 *메소드명 : modify
	 *기능 : 클래스 정보 수정
	 */
	@Override
	public boolean modify(ClassesVO classes) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 *작성자 : 김성원
	 *메소드명 : remove
	 *기능 : 클래스 정보 삭제
	 */
	@Override
	public boolean remove(Long classNo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*
	 *작성자 : 김성원
	 *메소드명 : getList
	 *기능 : 클래스 리스트 검색
	 */
	@Override
	public List<ClassesVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}
	

}
