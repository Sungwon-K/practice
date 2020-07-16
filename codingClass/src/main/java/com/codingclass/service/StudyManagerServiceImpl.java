package com.codingclass.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingclass.domain.ClassesVO;
import com.codingclass.mapper.ClassesMapper;
import com.codingclass.mapper.SessionMapper;
import com.codingclass.mapper.StudyVideoMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class StudyManagerServiceImpl implements StudyManagerService{

	@Setter(onMethod_= @Autowired)
	private ClassesMapper classMapper;
	
	@Setter(onMethod_= @Autowired)
	private SessionMapper sessionMapper;
	
	@Setter(onMethod_= @Autowired)
	private StudyVideoMapper studyVideoMapper;
	
	
	/*
	 *작성자 : 김성원
	 *메소드명 : register
	 *기능 : 클래스 정보 입력
	 */
	@Override
	public void register(ClassesVO classes) {
		log.info("regisert :" + classes);
		classMapper.classInsert(classes);	
		
		if(classes.getSessionList() == null || classes.getSessionList().size() <= 0) {
			return;
		}
		
		classes.getSessionList().forEach(session ->{
			session.setClassNo(classes.getClassNo());		
			sessionMapper.sessionInsert(session);
			
			if(session.getSessionList() == null || classes.getSessionList().size() <= 0) {
				return;
			}
			
		});
		
		
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
		return classMapper.getList();
	}
	

}
