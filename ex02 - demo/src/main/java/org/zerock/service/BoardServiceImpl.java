package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Log4j
@Service

//자동주입시 필요
@AllArgsConstructor
public class BoardServiceImpl implements BoardService{
	
	//자동주입
	private BoardMapper mapper;
	
	@Override
	public BoardVO get(Long bno) {
		log.info("get...............");
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("modify............");
		return mapper.update(board)==1;
	}

	@Override
	public boolean remove(Long bno) {
		log.info("remove..."+bno);
		return mapper.delete(bno)==1;
	}
	

	@Override
	public void register(BoardVO board) {
		log.info("register...........");
		mapper.insertSelectKey(board);
		
	}
	
	@Override
	   public List<BoardVO> getList(Criteria cri) {
	      log.info("getList with criteria: " + cri);
	      
	      
	      return mapper.getListWithPaging(cri);
	   }

	@Override
	public int getTotal(Criteria cri) {
		log.info("get total count");
		return mapper.getTotalCount(cri);
	}

  
}
