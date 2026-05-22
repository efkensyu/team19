package com.example.demo.team19.Comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, String> {
	public List<Comment> findByCommentCd(String code);
}
