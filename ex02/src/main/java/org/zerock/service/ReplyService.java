package org.zerock.service;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyPageDTO;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	//등록
	public int register(ReplyVO vo);
	//목록
	//public List<ReplyVO> getList(Criteria cri,Long bno);
	public ReplyPageDTO getListPage(Criteria cri,Long bno);
	
	//상세보기
	public ReplyVO get(Long rno);
	//수정
	public int modify(ReplyVO vo);
	//삭제
	public int remove(Long rno);
	
}
