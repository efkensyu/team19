package com.example.demo.team19.team19Mood;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class Team19MoodService {
		private final Team19MoodRepository repository;
		
		public List<Team19Mood> findAll(){
			return repository.findAll();
		}
		
		public List<Team19Mood> findNm(String code){
		//	return repository.findByBumonCd(code);
			return repository.findByMoodCd(code);
		}
}
