package com.yhdc.jspblog.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yhdc.jspblog.dto.ResetPwd;
import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.model.enums.EnableType;
import com.yhdc.jspblog.model.enums.RoleType;
import com.yhdc.jspblog.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class UserService {

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	// Join User
	@Transactional
	public Integer joinUser(User newUser) {
		try {
			newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
			newUser.setRole(RoleType.USER);
			newUser.setEnable(EnableType.ENABLE);
			userRepository.save(newUser);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	// Find user
	@Transactional(readOnly = true)
	public User findUserByEmail(String email) {
		User user = userRepository.findByEmail(email).orElseGet(() -> {
			return new User();
		});

		return user;
	}

	// Search and List User
	@Transactional(readOnly = true)
	public Page<User> userSearchList(String username, String email,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

		Page<User> users = userRepository.findByUsernameContainingOrEmailContaining(username, email, pageable);

		return users;
	}

	// Detail
	@Transactional(readOnly = true)
	public User detail(Long id) {

		User user = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("THE USER DOES NOT EXIST.");
		});
		return user;
	}

	// Reset Password
	@Transactional
	public Integer resetPwd(Long id, ResetPwd resetPwd) {
		User persistance = userRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("THE USER DOES NOT EXIST.");
		});

		if (persistance.getOauth() == null) {
			//persistance.setEmail(updateUser.getEmail());
			persistance.setPassword(bCryptPasswordEncoder.encode(resetPwd.getNewPassword()));
		} else {
			return -1;
		}
		return 1;
	}
	
	// Recover Password
	@Transactional
	public Integer recoverPwd(User recoverPwd) {
		
		String username = recoverPwd.getUsername();
		
		User persistance = userRepository.findByUsername(username).orElseThrow(() -> {
			return new IllegalArgumentException("THE USER DOES NOT EXIST.");
		});
		
		

		if (persistance.getOauth() == null) {
			//persistance.setPassword(bCryptPasswordEncoder.encode(updateUser.getPassword()));
		} else {
			return -1;
		}
		return 1;
	}

	// Delete User
	@Transactional
	public Integer deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
		} catch (Exception e) {
			return -1;
		}
		return 1;
	}

}
