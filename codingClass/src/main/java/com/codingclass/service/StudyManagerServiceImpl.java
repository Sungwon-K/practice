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
	 *메소드명 : getList
	 *기능 : 클래스 리스트 검색
	 */
	@Override
	public List<ClassesVO> getList() {
		// TODO Auto-generated method stub
		return mapper.getList();
	}

}
