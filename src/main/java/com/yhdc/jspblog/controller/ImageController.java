package com.yhdc.jspblog.controller;

import java.io.IOException;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yhdc.jspblog.config.auth.PrincipalDetail;
import com.yhdc.jspblog.service.ImageService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequiredArgsConstructor
public class ImageController {

	private final ImageService imageService;

	// Upload Page
	@GetMapping("/image/profileimage")
	public String uploadImage(@AuthenticationPrincipal PrincipalDetail principal) {
		return "image/profileimage";
	}

	// Post Image
	@PostMapping("/image/post")
	public String uploadImageFile(@AuthenticationPrincipal PrincipalDetail principalDetail,
			@RequestParam("file") MultipartFile file) throws IOException {

		log.info("Principal: ", principalDetail);
		log.info("Image: ", file);

		imageService.uploadImage(principalDetail, file);

		return "redirect: /";
	}

	// TODO Get
	@GetMapping("/image/get")
	public String getImage(@AuthenticationPrincipal PrincipalDetail principalDetail,
			@RequestParam("file") MultipartFile file) throws IOException {
		
		return "redirect: /";
	}
}
