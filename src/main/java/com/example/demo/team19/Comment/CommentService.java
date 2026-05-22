package com.example.demo.team19.Comment;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CommentService {
		private final CommentRepository repository;
		
		public List<Comment> findAll(){
			return repository.findAll();
		}
		
		public List<Comment> findNm(String code){
		//	return repository.findByBumonCd(code);
			return repository.findByCommentCd(code);
		}
}
