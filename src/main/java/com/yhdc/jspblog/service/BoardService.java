package com.yhdc.jspblog.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhdc.jspblog.model.Board;
import com.yhdc.jspblog.model.PrivacyType;
import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;

	// List
	@Transactional(readOnly = true)
	public Page<Board> list(Pageable pageable) {

		return boardRepository.findAll(pageable);
	}

	// Search List
	@Transactional(readOnly = true)
	public Page<Board> boardSearchList(String title, String content, Pageable pageable) {
		Page<Board> boards = boardRepository.findByTitleContainingOrContentContaining(title, content, pageable);

		return boards;
	}

	// Read
	@Transactional(readOnly = true)
	public Board read(Long id) {
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("THE BOARD DOES NOT EXIST.");
		});
		return board;
	}

	// Register
	@Transactional
	public Integer registerBoard(Board newBoard, User user) {
		try {
			newBoard.setCount(0);
			newBoard.setPrivacy(PrivacyType.PUBLIC);
			newBoard.setUser(user);
			boardRepository.save(newBoard);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("BoardService: register()" + e.getMessage());
		}
		return -1;
	}

	// Update Board
	@Transactional
	public Integer updateBoard(Long id, Board updateBoard) {
		Board board = boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("THE BOARD DOES NOT EXIST.");
		});

		board.setTitle(updateBoard.getTitle());
		board.setContent(updateBoard.getContent());

		return 1;
	}

	// Delete Board
	@Transactional
	public Integer deleteBoard(Long id) {
		try {
			boardRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return -1;
		}
		return 1;
	}
}
