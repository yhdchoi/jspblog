package com.yhdc.jspblog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yhdc.jspblog.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	Page<Comment> findByContentContaining(String content, Pageable pageable);

}
