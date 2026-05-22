package com.example.demo.team19.Janru;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JanruRepository extends JpaRepository<Janru, String> {
	public List<Janru> findByJanruCd(String code);
}
