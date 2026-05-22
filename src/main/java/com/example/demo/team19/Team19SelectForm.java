package com.example.demo.team19;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Team19SelectForm {
	@NotBlank(message = "いずれかを選択してください")
	private String select;
	
//	@NotBlank
//	private String comment;
}


