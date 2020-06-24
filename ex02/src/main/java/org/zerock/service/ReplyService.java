package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	//등록
	public int register(ReplyVO vo);
	//목록
	public List<ReplyVO> getList(Criteria cri, Long bno);
	//상세보기
	public ReplyVO get(Long rno);
	//수정하기
	public int modify(ReplyVO vo);
	//삭제하기
	public int remove(Long rno);
}
