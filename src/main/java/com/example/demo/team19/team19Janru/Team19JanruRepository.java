package com.example.demo.team19.team19Janru;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Team19JanruRepository extends JpaRepository<Team19Janru, String> {
	public List<Team19Janru> findByJanruCd(String code);
}
