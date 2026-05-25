package com.example.demo.team19.team19Comment;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class Team19CommentService {
		private final Team19CommentRepository repository;
		
		public List<Team19Comment> selectComment(String janru, String mood){
			return repository.selectComment(mood, janru);
		}
		
		public void insertComment(Date date, Integer musicCd, String text) {
			repository.insertComment(date, musicCd, text);
		}

		public List<Team19Comment> findAll() {
			// TODO 自動生成されたメソッド・スタブ
			return repository.findAll();
			
		}

}
