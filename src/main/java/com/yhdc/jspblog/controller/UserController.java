package com.yhdc.jspblog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yhdc.jspblog.config.auth.PrincipalDetail;

@Controller
public class UserController {

	// Join
	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "auth/joinForm";
	}

	// Login
	@GetMapping("/auth/loginForm")
	public String login() {
		return "auth/loginForm";
	}

	// Password Recover
	@GetMapping("/auth/password")
	public String recoverPwd() {
		return "auth/password";
	}

	// User Update
	@GetMapping("/user/profile")
	public String updateUser(@AuthenticationPrincipal PrincipalDetail principal) {
		return "user/profile";
	}

	// Logout
	@GetMapping("/logout")
	public String logout() {
		return "/";
	}

}
