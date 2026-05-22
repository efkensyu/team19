package com.example.demo.team19.Mood;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MoodService {
		private final MoodRepository repository;
		
		public List<Mood> findAll(){
			return repository.findAll();
		}
		
		public List<Mood> findNm(String code){
		//	return repository.findByBumonCd(code);
			return repository.findByMoodCd(code);
		}
}
