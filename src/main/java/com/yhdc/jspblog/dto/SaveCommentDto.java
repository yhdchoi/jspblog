package com.yhdc.jspblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveCommentDto {

	private Long userId;
	private Long boardId;
	private String content;
}
