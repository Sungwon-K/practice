package com.codingclass.domain;

import java.util.Date;

import lombok.Data;

@Data
public class UsersVO {
	
	private long userNo;
	private String userId;
	private String pw;
	private String userState;
	private String userNickName;
	private String userComment;
		
	private Date userRegDate;
	private Date userUpdateDate;
	
	private String userProfile;
	
	private int loginCount;
}
