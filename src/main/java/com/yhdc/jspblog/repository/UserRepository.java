package com.yhdc.jspblog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yhdc.jspblog.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	// Search and List
	Page<User> findByUsernameContainingOrEmailContaining(String username, String email, Pageable pageable);

	// Form Login
	User findByEmailAndPassword(String email, String password);
}
