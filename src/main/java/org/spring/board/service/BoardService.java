package org.spring.board.service;

import java.util.List;

import org.spring.board.domain.BoardVO;
import org.spring.board.mappers.BoardMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor // lombok 생성자 어노테이션
@Transactional
public class BoardService {
	
	// DI -> @RequiredArgConstructor로 대체 
	//	public BoardService(BoardMapper boardMapper) {
	//		this.boardMapper = boardMapper;
	//	}
	
	private final BoardMapper boardMapper;
	
	// 글 등록
	public Long register(BoardVO boardVO) {
		log.info("-----------------------" + boardVO);
		
		int count = boardMapper.insert(boardVO);
		
		Long bno = boardMapper.getCurrentSeqNo();
		
		return bno;
	}
	
	// 전체 글 조회
	public List<BoardVO> list(){
		return boardMapper.getList();
	}
	
	// 상세 글 조회
	public BoardVO get(Long bno) {
		return boardMapper.select(bno);
	}
	
	// 글 수정
	public boolean modify(BoardVO vo) {
		// UPDATE가 정상동작 됬다면 1 return
		return boardMapper.update(vo) == 1;
	}
	
	// 글 삭제
	public boolean remove(Long bno) {
		return true; //임시
	}
	
	

}
