package org.spring.board.mappers;

import java.util.List;

import org.spring.board.domain.BoardVO;

public interface BoardMapper {
	
	List<BoardVO> getList();
	
	int insert(BoardVO boardVO);
	
	BoardVO select(Long bno);
	
	int update(BoardVO boardVO);
}
