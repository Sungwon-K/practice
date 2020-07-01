package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardAttachVO;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardService {
	
	//입력
	public void register(BoardVO board);
	//1건검색
	public BoardVO get(Long bno);
	//수정
	public boolean modify(BoardVO board);
	//삭제
	public boolean remove(Long bno);
	//목록
	//public List<BoardVO> getList();
	public List<BoardVO> getList(Criteria cri);
	//추가
	public int getTotal(Criteria cri);
	
	public List<BoardAttachVO> getAttachList(Long bno);
	
	
}
