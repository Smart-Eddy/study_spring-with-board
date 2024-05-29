package org.spring.board.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import lombok.extern.log4j.Log4j2;

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardServiceTest {
	
	@Autowired
	BoardService boardService;
	
	@Test
	public void testList() {
		log.info(boardService.list());
		
	}
	

}
