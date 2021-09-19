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
import org.springframework.web.multipart.MultipartFile;

import com.yhdc.jspblog.dto.RecoverUserDto;
import com.yhdc.jspblog.dto.UpdateUserDto;
import com.yhdc.jspblog.exception.ApiRequestException;
import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserApiController {

	private final UserService userService;

	// Join
	@PostMapping("/auth/joinProc")
	public ResponseEntity<String> joinUser(@RequestBody User newUser, @RequestParam("file") MultipartFile file) {

		int result = userService.joinUser(newUser, file);

		if (result == -1) {
			return new ResponseEntity<String>("Existing User.", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successful.", HttpStatus.OK);
	}

	// Search and List User
	@GetMapping("/user/list")
	public ResponseEntity<Page<User>> userSearchList(@RequestParam String username, @RequestParam String email,
			@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {

		try {
			Page<User> users = userService.userSearchList(username, email, pageable);
			return new ResponseEntity<Page<User>>(users, HttpStatus.OK);
		} catch (Exception e) {
			throw new ApiRequestException("User Does NOT Exist.");
		}
	}

	// Detail
	@GetMapping("/user/detail/{id}")
	public ResponseEntity<User> detail(@PathVariable Long id) {

		try {
			User user = userService.detail(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} catch (Exception e) {
			throw new ApiRequestException("User Does NOT Exist.");
		}
	}

	// Reset Password
	@PutMapping("/user/reset/{id}")
	public ResponseEntity<String> updateUserDto(@PathVariable Long id, @RequestBody UpdateUserDto updateUserDto,
			@RequestParam("file") MultipartFile file) {

		int result = userService.updateUserDto(id, updateUserDto);

		if (result == -1) {
			return new ResponseEntity<String>("Fail To Update.", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successful.", HttpStatus.OK);
	}

	// Recover Password
	@PutMapping("/auth/recover")
	public ResponseEntity<String> recoverUserDto(@RequestBody RecoverUserDto recoverUserDto) {

		int result = userService.checkUser(recoverUserDto);

		if (result == -1) {
			return new ResponseEntity<String>("Fail To Recover.", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successful.", HttpStatus.OK);
	}

	// Delete User
	@DeleteMapping("/user/remove/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {

		int result = userService.deleteUser(id);

		if (result == -1) {
			return new ResponseEntity<String>("Fail To Delete.", HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<String>("Successful.", HttpStatus.OK);
	}

}
