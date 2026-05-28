package com.example.demo.team19;

import lombok.Data;

@Data
public class vision {
	private String musicNm;
	private String artist;
	private String musicUrl;
	private String jampUrl;
	 vision(String musicNm, String artist, String musicUrl, String jampUrl){
		this.musicNm = musicNm;
		this.artist = artist;
		this.musicUrl = musicUrl;
		this.jampUrl = jampUrl;
	}
}
