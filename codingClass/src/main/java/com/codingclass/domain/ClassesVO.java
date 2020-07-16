package com.codingclass.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class ClassesVO {
	private long classNo;
	
	private String classTitle;
	
	private long userNo;
	
	private String classInfo;
	private String classCurriculum;
	private String classLevel;
	private String classThumnail;
	private String classFlag;
	private	String classDetail;
	
	private Date classDate;
	
	private List<SessionVO> sessionList;
}
