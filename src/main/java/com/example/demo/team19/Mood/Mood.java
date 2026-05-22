package com.example.demo.team19.Mood;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team19_kibun_tbl")
@Data
public class Mood {
	@Id
	private String moodCd;
	private String moodNm;
//気分テーブル
}
