package com.yhdc.jspblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecoverMail {

	private String email;
	private String title;
	private String message;
}
