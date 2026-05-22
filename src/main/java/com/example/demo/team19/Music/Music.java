package com.example.demo.team19.Music;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team19_music_tbl")
@Data
public class Music {
	@Id
	private String musicCd;
	private String musicNm;
	private String artist;
	private String janruCd;
	private String musicUrl;
	private String like;
}
