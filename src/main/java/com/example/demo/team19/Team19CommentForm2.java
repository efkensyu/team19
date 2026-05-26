package com.example.demo.team19;

import java.sql.Date;

import lombok.Data;

@Data
public class Team19CommentForm2 {	
	private String comment;
	private Date commentDate;
	private String musicNm;
	
	public Team19CommentForm2(Date date,  String name,String comment) {
		this.commentDate = date;
		this.comment = comment;
		this.musicNm = name;
	}
	
}
