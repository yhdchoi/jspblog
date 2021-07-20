package com.yhdc.jspblog.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.yhdc.jspblog.model.Board;
import com.yhdc.jspblog.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;

	@GetMapping({ "", "/" })
	public String index(Model model, @RequestParam(required = false, defaultValue = "") String search,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

		Page<Board> boards = boardService.boardSearchList(search, search, pageable);

		int pageNumber = boards.getPageable().getPageNumber();
		int totalPages = boards.getTotalPages();
		int pageBlock = 5;
		int startBlockPage = ((pageNumber) / pageBlock) * pageBlock + 1;
		int endBlockPage = startBlockPage + pageBlock - 1;
		endBlockPage = totalPages < endBlockPage ? totalPages : endBlockPage;

		model.addAttribute("startBlockPage", startBlockPage);
		model.addAttribute("endBlockPage", endBlockPage);
		model.addAttribute("boards", boards);
		return "index";
	}

	@GetMapping("/board/registerBoard")
	public String registerBoard() {
		return "board/registerBoard";
	}
	
	@GetMapping("/board/update/{id}")
	public String updateBoard(Model model, @PathVariable Long id) {		
		model.addAttribute("board", boardService.read(id));
		return "board/updateForm";
	}

	@GetMapping("/board/{id}")
	public String read(Model model, @PathVariable Long id) {
		
		Board board = boardService.read(id);		
		model.addAttribute("board", board);
		
		return "/board/detail";
	}

}
