package com.yhdc.jspblog.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yhdc.jspblog.config.auth.PrincipalDetail;

@Controller
public class UserController {

	@GetMapping("/auth/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}

	@GetMapping("/auth/loginForm")
	public String login() {
		return "user/loginForm";
	}
	
	@GetMapping("/user/profile")
	public String updateUser(@AuthenticationPrincipal PrincipalDetail principal) {
		return "user/profile";
	}

	@GetMapping("/logout")
	public String logout() {
		return "/";
	}

}
