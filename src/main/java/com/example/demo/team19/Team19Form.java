package com.example.demo.team19;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Team19Form {
	@NotBlank(message = "未入力です。" )	
	private String name;
	
//	@NotBlank
//	private String comment;
}
