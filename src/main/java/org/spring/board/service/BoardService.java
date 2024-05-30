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
@RequiredArgsConstructor // lombok ������ ������̼�
@Transactional
public class BoardService {
	
	// DI -> @RequiredArgConstructor�� ��ü 
	//	public BoardService(BoardMapper boardMapper) {
	//		this.boardMapper = boardMapper;
	//	}
	
	private final BoardMapper boardMapper;
	
	// �� ���
	public Long register(BoardVO boardVO) {
		log.info("-----------------------" + boardVO);
		
		int count = boardMapper.insert(boardVO);
		
		Long bno = boardMapper.getCurrentSeqNo();
		
		return bno;
	}
	
	// ��ü �� ��ȸ
	public List<BoardVO> list(){
		return boardMapper.getList();
	}
	
	// �� �� ��ȸ
	public BoardVO get(Long bno) {
		return boardMapper.select(bno);
	}
	
	// �� ����
	public boolean modify(BoardVO vo) {
		// UPDATE�� ������ ��ٸ� 1 return
		return boardMapper.update(vo) == 1;
	}
	
	// �� ����
	public boolean remove(Long bno) {
		return true; //�ӽ�
	}
	
	

}
