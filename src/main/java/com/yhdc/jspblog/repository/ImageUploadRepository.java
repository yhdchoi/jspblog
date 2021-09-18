package com.yhdc.jspblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhdc.jspblog.model.Image;

public interface ImageUploadRepository extends JpaRepository<Image, Long> {

	
}
