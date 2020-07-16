package com.codingclass.domain;

import java.util.List;

import lombok.Data;


@Data
public class SessionVO {
	
	private long sessionNo;
	private String sessionTitle;
	
	private long classNo;
	
	private List<StudyVideoVO> studyVideoList;
	
}
