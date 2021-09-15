package com.yhdc.jspblog.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Like {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// ID, Username, ProfileImage
	@ManyToOne
	@JoinColumn(name = "userId")
	@JsonIgnoreProperties({ "password", "email", "oauth", 
		"role", "enable", "images", "regDate", "modDate" })
	private User user;

	
	@ManyToOne
	@JoinColumn(name = "boardId")
	@JsonIgnoreProperties({"title", "content", "count", "privacy", 
		"user", "comments", "likes", "regDate", "modDate"})
	@JsonBackReference
	private Board board;

	@CreationTimestamp
	private Timestamp regDate;

	@UpdateTimestamp
	private Timestamp modDate;
}
