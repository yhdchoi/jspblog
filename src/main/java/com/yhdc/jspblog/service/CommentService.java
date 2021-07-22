package com.yhdc.jspblog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhdc.jspblog.dto.SaveCommentDto;
import com.yhdc.jspblog.model.Board;
import com.yhdc.jspblog.model.Comment;
import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.model.enums.PrivacyType;
import com.yhdc.jspblog.repository.BoardRepository;
import com.yhdc.jspblog.repository.CommentRepository;
import com.yhdc.jspblog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private final CommentRepository commentRepository;
	private final BoardRepository boardRepository;
	private final UserRepository userRepository;

	// TODO Search List
	@Transactional(readOnly = true)
	public Page<Comment> commentSearchList(String content,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<Comment> comments = commentRepository.findByContentContaining(content, pageable);

		return comments;
	}

	// Save
	@Transactional
	public Integer saveComment(SaveCommentDto commentDto) {

		// TODO Select method
		PrivacyType privacyType = PrivacyType.PUBLIC;

		String content = commentDto.getContent();
		User user = userRepository.getById(commentDto.getUserId());
		Board board = boardRepository.getById(commentDto.getBoardId());

		Comment newComment = new Comment();
		newComment.save(content, privacyType, user, board);

		commentRepository.save(newComment);
		return 1;
	}

	// TODO Update
	@Transactional
	public Comment updateComment(Long id, Comment newComment) {
		Comment comment = commentRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("THE COMMENT DOES NOT EXIST.");
		});
		comment.setContent(newComment.getContent());

		return comment;
	}

	// Delete
	@Transactional
	public void deleteComment(Long commentId) {

		commentRepository.deleteById(commentId);

	}
}
