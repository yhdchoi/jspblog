package com.yhdc.jspblog.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.yhdc.jspblog.model.User;

public interface UserRepository extends JpaRepository<User, Long> {	
	
	Optional<User> findByUsername(String username);
	
	Optional<User> findByEmail(String email);
	
	// Search and List
	Page<User> findByUsernameContainingOrEmailContaining(String username, String email, Pageable pageable);

}
