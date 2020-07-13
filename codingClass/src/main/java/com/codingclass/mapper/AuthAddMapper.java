package com.codingclass.mapper;

import com.codingclass.domain.UsersVO;

public interface AuthAddMapper {
	/*
	 *작성자 : 김성원
	 *메소드명 : authAdd
	 *기능 : 권한 테이블에 해당 유저의 강사 권한 추가 등록
	 */
	public void authAdd(UsersVO userNo);
}
