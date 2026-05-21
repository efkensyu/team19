package com.example.demo.team19;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Team19Form {
	@NotNull(message = "未入力です。" )	
	private String name;
	
//	@NotBlank
//	private String comment;
}
