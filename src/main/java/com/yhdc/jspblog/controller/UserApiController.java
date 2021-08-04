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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yhdc.jspblog.dto.RecoverPwd;
import com.yhdc.jspblog.dto.ResetPwd;
import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;

	// Join
	@PostMapping("/auth/joinProc")
	public ResponseEntity<Integer> joinUser(@RequestBody User newUser) {

		int result = userService.joinUser(newUser);

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	// Search and List User
	@GetMapping("/user/list")
	public ResponseEntity<Page<User>> userSearchList(@RequestParam String username, @RequestParam String email,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

		Page<User> users = userService.userSearchList(username, email, pageable);

		return new ResponseEntity<Page<User>>(users, HttpStatus.OK);
	}

	// Detail
	@GetMapping("/user/detail/{id}")
	public ResponseEntity<User> detail(@PathVariable Long id) {

		User user = userService.detail(id);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	// Reset Password
	@PutMapping("/user/reset/{id}")
	public ResponseEntity<Integer> resetPwd(@PathVariable Long id, @RequestBody ResetPwd resetPwd) {

		int result = userService.resetPwd(id, resetPwd);

		// TODO Force session update?

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	// Recover Password
	@PutMapping("/user/recover")
	public ResponseEntity<Integer> recoverPwd(@RequestBody RecoverPwd recoverPwd) {

		int result = userService.checkUser(recoverPwd);

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

	// Delete User
	@DeleteMapping("/user/remove/{id}")
	public ResponseEntity<Integer> deleteUser(@PathVariable Long id) {

		int result = userService.deleteUser(id);

		return new ResponseEntity<Integer>(result, HttpStatus.OK);
	}

}
