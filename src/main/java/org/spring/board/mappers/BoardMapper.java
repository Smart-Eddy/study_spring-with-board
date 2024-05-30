package org.spring.board.mappers;

import java.util.List;

import org.spring.board.domain.BoardVO;

public interface BoardMapper {
	
	List<BoardVO> getList();
	
	long getCurrentSeqNo();
	
	int insert(BoardVO boardVO);
	
	BoardVO select(Long bno);
	
	int update(BoardVO boardVO);
}
