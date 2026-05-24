package com.example.demo.team19.team19Comment;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team19_comment_tbl")
@Data
public class Team19Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentCd;
	private LocalDate commentDate;
	private Integer musicCd;
	private String commentText;
	
//コメントテーブル
}
