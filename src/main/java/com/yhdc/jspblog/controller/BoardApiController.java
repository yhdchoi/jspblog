package com.yhdc.jspblog.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yhdc.jspblog.config.auth.PrincipalDetail;
import com.yhdc.jspblog.model.Board;
import com.yhdc.jspblog.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

	private final BoardService boardService;

	// Search List
	@GetMapping("/api/board/listSearch")
	public ResponseEntity<Page<Board>> boardSearchList(@RequestParam(required = false, defaultValue = "") String title,
			@RequestParam(required = false, defaultValue = "") String content,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		
		Page<Board> boards = boardService.boardSearchList(title, content, pageable);

		return new ResponseEntity<Page<Board>>(boards, HttpStatus.OK);
	}

	// Detail
	@GetMapping("/api/board/read/{id}")
	public ResponseEntity<Board> detail(@PathVariable Long id) {
		
		Board board = boardService.detail(id);

		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}

	// Save
	@PostMapping("/api/board/register")
	public ResponseEntity<Integer> saveBoard(@RequestBody Board newBoard,
			@AuthenticationPrincipal PrincipalDetail principal) {
		
		Integer result = boardService.saveBoard(newBoard, principal.getUser());

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	// Update 
	@PutMapping("/api/board/update/{id}")
	public ResponseEntity<Integer> updateBoard(@PathVariable Long id, @RequestBody Board newBoard) {

		boardService.updateBoard(id, newBoard);

		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}

	// Delete 
	@DeleteMapping("/api/board/delete/{id}")
	public ResponseEntity<Integer> deleteBoard(@PathVariable Long id) {

		boardService.deleteBoard(id);

		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}

}
