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

import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth/")
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;
	
	// Join
	@PostMapping("/joinProc")
	public ResponseEntity<Integer> joinUser(@RequestBody User newUser) {

		int result = userService.joinUser(newUser);

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	// Search and List User
	@GetMapping("/list")
	public ResponseEntity<Page<User>> userSearchList(@RequestParam String username, @RequestParam String email,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

		Page<User> users = userService.userSearchList(username, email, pageable);

		return new ResponseEntity<Page<User>>(users, HttpStatus.OK);
	}

	// Detail
	@GetMapping("/detail/{id}")
	public ResponseEntity<User> detail(@PathVariable Long id) {

		User user = userService.detail(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// Update User
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updateUser) {

		User user = userService.updateUser(id, updateUser);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// Delete User
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {

		String result = userService.deleteUser(id);

		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	// Form Login
//	@PostMapping("/login")
//	public ResponseEntity<Integer> login(@RequestBody User user, HttpSession session) {
//
//		User principal = userService.loginUser(user);
//		if(principal != null) {
//			session.setAttribute("principal", principal);
//		}
//		
//		return new ResponseEntity<Integer>(result, HttpStatus.OK);
//	}
}
