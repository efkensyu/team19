package com.example.demo.team19.Mood;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MoodRepository extends JpaRepository<Mood, String> {
	public List<Mood> findByMoodCd(String code);
}
