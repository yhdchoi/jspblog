package com.yhdc.jspblog.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yhdc.jspblog.dto.SaveCommentDto;
import com.yhdc.jspblog.model.Comment;
import com.yhdc.jspblog.service.CommentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/comment/")
@RequiredArgsConstructor
public class CommentApiController {

	private final CommentService commentService;

	//TODO Search List
	@GetMapping("/list")
	public ResponseEntity<Page<Comment>> commentSearchList(@RequestParam String content,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		
		Page<Comment> comments = commentService.commentSearchList(content, pageable);

		return new ResponseEntity<Page<Comment>>(comments, HttpStatus.OK);
	}

	// New Comment
	@PostMapping("/api/board/{id}/comment")
	public ResponseEntity<Integer> saveComment(@RequestBody SaveCommentDto newComment) {

		Integer result = commentService.saveComment(newComment);

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	//TODO Update Comment
	@PutMapping("/update/{id}")
	public ResponseEntity<Comment> updateComment(@PathVariable Long id, @RequestBody Comment newComment) {
		
		Comment comment = commentService.updateComment(id, newComment);

		return new ResponseEntity<Comment>(comment, HttpStatus.OK);
	}

	//TODO Delete Comment
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Integer> deleteComment(@PathVariable Long id) {
		
		int result = commentService.deleteComment(id);

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}
}
