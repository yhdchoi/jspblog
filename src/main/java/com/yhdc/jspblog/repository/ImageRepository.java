package com.yhdc.jspblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yhdc.jspblog.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {

	
}
