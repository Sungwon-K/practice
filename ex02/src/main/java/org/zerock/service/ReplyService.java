package org.zerock.service;

import java.util.List;

import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;

public interface ReplyService {
	//등록
	public int register(ReplyVO vo);
	//목록
	public List<ReplyVO> getList(Criteria cri, Long bno);
}
