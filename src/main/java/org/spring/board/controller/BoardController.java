package org.spring.board.controller;

import java.util.List;

import org.spring.board.domain.BoardVO;
import org.spring.board.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
	
	private final BoardService boardService;
	
	// 게시글 전체 조회
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("list....");
		
		List<BoardVO> list = boardService.list();
		
		log.info(list);
		
		model.addAttribute("list", list);
	}
	
	// 상세 글 조회(read)와 글 수정(modify)의 동작이 동일하기 때문에 @PathVariable을 여러개를 받아 처리해서 하나의 메서드에서 처리할 수 있다
	// 상세 글 조회 & 글 수정
	@GetMapping("/{job}/{bno}") // PathVariable 처리 : PathVariable이 여러개일 수 있기 때문에 name값을 지정하는 것이 좋다.
	public String read(@PathVariable(name = "job") String job,
						@PathVariable(name = "bno") Long bno, Model model) {
		
		log.info("job : " + bno);
		log.info("bno : " + bno);
		
		if(!(job.equals("read") || job.equals("modify"))) {
			throw new RuntimeException("Bad Request Job!");
		}
			
		BoardVO boardVO = boardService.get(bno);
		
		log.info("boardVO : " + boardVO);
		
		model.addAttribute("vo", boardVO);
		
		return "/board/" + job;
	}
	
	// 상세 글 수정
	//	@GetMapping("/modify/{bno}")
	//	public String modify(@PathVariable(name = "bno") Long bno, Model model) {
	//		
	//		log.info("bno : " + bno);
	//		
	//		BoardVO boardVO = boardService.get(bno);
	//		
	//		log.info("boardVO : " + boardVO);
	//		
	//		model.addAttribute("vo", boardVO);
	//		
	//		return "/board/modify";
	//	}
	
	// 글 등록
	@GetMapping("/register")
	public void register() {
		// return이 없는 void일 때는 Spring MVC가 요청 URL을 기반으로 view를 return하게 된다.
	}
	
	// 글 등록
	@PostMapping("/register")
	public String registerPost(BoardVO boardVO, RedirectAttributes rttr) {
		
		log.info("BoardVO : " + boardVO);
		
		Long bno = boardService.register(boardVO);
		
		rttr.addFlashAttribute("result", bno);
		
		// 글 등록이 됬다면 글 전체조회 페이지로 redirect
		return "redirect:/board/list";
	}
}
