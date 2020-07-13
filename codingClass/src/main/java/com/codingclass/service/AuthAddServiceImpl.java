package com.codingclass.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingclass.domain.UsersVO;
import com.codingclass.mapper.AuthAddMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class AuthAddServiceImpl implements AuthAddService{

	@Setter(onMethod_= @Autowired)
	private AuthAddMapper Mapper;
	
	
	/*
	 *작성자 : 김성원
	 *메소드명 : authAdd
	 *기능 : 권한 테이블에 해당 유저의 강사 권한 추가 등록
	 */
	@Override
	public void authAdd(UsersVO userNo) {
		log.info("권한부여");
		
		Mapper.authAdd(userNo);		
	}

}
