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
	
	// �Խñ� ��ü ��ȸ
	@GetMapping("/list")
	public void list(Model model) {
		
		log.info("list....");
		
		List<BoardVO> list = boardService.list();
		
		log.info(list);
		
		model.addAttribute("list", list);
	}
	
	// �� �� ��ȸ(read)�� �� ����(modify)�� ������ �����ϱ� ������ @PathVariable�� �������� �޾� ó���ؼ� �ϳ��� �޼��忡�� ó���� �� �ִ�
	// �� �� ��ȸ & �� ����
	@GetMapping("/{job}/{bno}") // PathVariable ó�� : PathVariable�� �������� �� �ֱ� ������ name���� �����ϴ� ���� ����.
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
	
	// �� �� ����
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
	
	// �� ���
	@GetMapping("/register")
	public void register() {
		// return�� ���� void�� ���� Spring MVC�� ��û URL�� ������� view�� return�ϰ� �ȴ�.
	}
	
	// �� ���
	@PostMapping("/register")
	public String registerPost(BoardVO boardVO, RedirectAttributes rttr) {
		
		log.info("BoardVO : " + boardVO);
		
		Long bno = boardService.register(boardVO);
		
		rttr.addFlashAttribute("result", bno);
		
		// �� ����� ��ٸ� �� ��ü��ȸ �������� redirect
		return "redirect:/board/list";
	}
}
