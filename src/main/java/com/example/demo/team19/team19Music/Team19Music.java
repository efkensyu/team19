package com.example.demo.team19.team19Music;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team19_music_tbl")
@Data
public class Team19Music {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer musicCd;
	private String musicNm;
	private String artist;
	private String janruCd;
	//重複
	private String musicUrl;
	private String likeCnt;
}
