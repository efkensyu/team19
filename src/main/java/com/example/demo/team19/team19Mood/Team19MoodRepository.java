package com.example.demo.team19.team19Mood;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Team19MoodRepository extends JpaRepository<Team19Mood, String> {
	public List<Team19Mood> findByMoodCd(String code);
}
