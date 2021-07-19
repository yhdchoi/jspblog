package com.yhdc.jspblog.service;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhdc.jspblog.model.EnableType;
import com.yhdc.jspblog.model.RoleType;
import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserRepository userRepository;

	// Form Login
//	@Transactional(readOnly = true)
//	public User loginUser(User user) {
//
//		User principal = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
//
//		return principal;
//	}

	// Search and List User
	public Page<User> userSearchList(String username, String email,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

		Page<User> users = userRepository.findByUsernameContainingOrEmailContaining(username, email, pageable);

		return users;
	}

	// Detail
	public User detail(Long id) {

		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("THE USER DOES NOT EXIST.");
		});

		return user;
	}

	// Join User
	@Transactional
	public User registerUser(User newUser) {

		newUser.setRole(RoleType.USER);
		newUser.setEnable(EnableType.ENABLE);

		User user = userRepository.save(newUser);

		return user;
	}

	// Update User
	@Transactional
	public User updateUser(Long id, User updateUser) {
		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("THE USER DOES NOT EXIST.");
		});

		user.setEmail(updateUser.getEmail());
		user.setPassword(updateUser.getPassword());

		return user;
	}

	// Delete User
	public String deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "THE USER DOES NOT EXIST.";
		}

		return "DELETED";
	}
}
