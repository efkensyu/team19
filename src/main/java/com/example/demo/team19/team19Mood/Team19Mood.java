package com.example.demo.team19.team19Mood;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team19_kibun_tbl")
@Data
public class Team19Mood {
	@Id
	private String moodCd;
	private String moodNm;
//気分テーブル
}
