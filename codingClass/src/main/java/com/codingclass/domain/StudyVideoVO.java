package com.codingclass.domain;

import java.util.Date;

import lombok.Data;

@Data
public class StudyVideoVO {
	private long studyVideoNo;
	private String studyVideoTitle; 
	private String studyUrl;
	private long sessionNo;
	private Date studyDate;
	private long studyVideoCount;
	
}
