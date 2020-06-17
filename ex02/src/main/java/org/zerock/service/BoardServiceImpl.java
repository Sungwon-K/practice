package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service

//자동주입시 필요
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	//자동주입
	private BoardMapper mapper;//자동주입
	
	@Override
	public BoardVO get(Long bno) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(BoardVO board) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Long bno) {
		// TODO Auto-generated method stub
		return false;
	}
	

	@Override
	public void register(BoardVO board) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<BoardVO> getList() {
		log.info("getList.............");
		return mapper.getList();
	}
	
}
