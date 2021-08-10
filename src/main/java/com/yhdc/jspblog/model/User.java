package com.yhdc.jspblog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.yhdc.jspblog.model.enums.EnableType;
import com.yhdc.jspblog.model.enums.OauthType;
import com.yhdc.jspblog.model.enums.RoleType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false)
	private Long id;

	@Column(length = 100, unique = true)
	private String username;

	@Column(length = 100, unique = true)
	private String email;

	@Column(length = 100)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = true)
	private OauthType oauth;

	@Enumerated(EnumType.STRING)
	private RoleType role;

	@Enumerated(EnumType.STRING)
	private EnableType enable;
	
	private String profileImage; //Image ID
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	@JsonManagedReference
	private List<Image> images;

	@CreationTimestamp
	private Timestamp regDate;

	@UpdateTimestamp
	private Timestamp modDate;

}
