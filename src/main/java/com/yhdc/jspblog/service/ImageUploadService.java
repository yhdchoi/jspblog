package com.yhdc.jspblog.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yhdc.jspblog.config.auth.PrincipalDetail;
import com.yhdc.jspblog.model.Image;
import com.yhdc.jspblog.model.User;
import com.yhdc.jspblog.repository.ImageUploadRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageUploadService {

	private final ImageUploadRepository imageUploadRepository;

	@Value("${file.path")
	private String fileRealPath;

	// Post
	public void uploadImage(PrincipalDetail principalDetail, MultipartFile file) throws IOException {

		UUID uuid = UUID.randomUUID();
		String uuidFilename = uuid + "_" + file.getOriginalFilename();
		Path filePath = Paths.get(fileRealPath + uuidFilename);
		Files.write(filePath, file.getBytes());

		User principal = principalDetail.getUser();

		Image image = new Image();
		image.setUser(principal);
		image.setImagePath(uuidFilename);

		imageUploadRepository.save(image);
	}

	// TODO Get

	// TODO Delete(insertDefaultImage)

}
