package com.example.demo.team19;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Team19CommentForm {
	@NotBlank(message = "未入力です。" )	
	private String comment;
	
//	@NotBlank
//	private String comment;
}
