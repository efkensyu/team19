package com.example.demo.team19;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class Team19RegisterForm {
	@NotBlank(message = "いずれかを選択してください。" )	
	private String Janru;
	@NotBlank(message = "いずれかを選択してください。" )
	private String Mood;
	@NotBlank(message = "未入力です。" )
	private String MusicNm;
	@NotBlank(message = "未入力です。" )
	private String Artist;
	@NotBlank(message = "未入力です。" )
	private String Url;

}


