package com.example.demo.team19.Comment;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "team19_comment_tbl")
@Data
public class Comment {
	@Id
	private String commentCd;
	private String commentDate;
	private String musicCd;
	private String commentText;
	
//コメントテーブル
}
