package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {
	//목록
	public List<BoardVO> getList();
	//목록 with paging
	public List<BoardVO> getListWithPaging(Criteria cri);
	//전체글수
	public int getTotalCount(Criteria cri);
	//등록
	public void insert(BoardVO board);
	//등록.bno를 리턴
	public void insertSelectKey(BoardVO board);	
	//상세보기
	public BoardVO read(Long bno);
	//수정
	public int update(BoardVO board);
	//삭제
	public int delete(Long bno);
	//댓글 수
	public void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
	
	
}
