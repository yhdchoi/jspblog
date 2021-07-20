package com.yhdc.jspblog.controller;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yhdc.jspblog.config.auth.PrincipalDetail;
import com.yhdc.jspblog.model.Board;
import com.yhdc.jspblog.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/board/")
@RequiredArgsConstructor
public class BoardApiController {

	private final BoardService boardService;

	// Search List
	@GetMapping("/listSearch")
	public ResponseEntity<Page<Board>> boardSearchList(@RequestParam(required = false,defaultValue = "") String title, @RequestParam(required = false,defaultValue = "") String content,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Board> boards = boardService.boardSearchList(title, content, pageable);

		return new ResponseEntity<Page<Board>>(boards, HttpStatus.OK);
	}

	// Read
	@GetMapping("/read/{id}")
	public ResponseEntity<Board> read(@PathVariable Long id) {
		Board board = boardService.read(id);

		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}

	// New Board
	@PostMapping("/register")
	public ResponseEntity<Integer> registerBoard(@Valid @RequestBody Board newBoard, @AuthenticationPrincipal PrincipalDetail principal) {
		Integer result = boardService.registerBoard(newBoard, principal.getUser());

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	// Update Board
	@PutMapping("/update/{id}")
	public ResponseEntity<Board> updateBoard(@PathVariable Long id, @Valid @RequestBody Board newBoard) {
		Board board = boardService.updateBoard(id, newBoard);

		return new ResponseEntity<Board>(board, HttpStatus.OK);
	}

	// Delete Board
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteBoard(@PathVariable Long id) {

		boardService.deleteBoard(id);

		return new ResponseEntity<String>("DELETED", HttpStatus.OK);
	}
}
