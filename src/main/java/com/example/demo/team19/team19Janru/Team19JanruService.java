package com.example.demo.team19.team19Janru;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class Team19JanruService {
		private final Team19JanruRepository repository;
		
		public List<Team19Janru> findAll(){
			return repository.findAll();
		}
		
		public List<Team19Janru> findNm(String code){
		//	return repository.findByBumonCd(code);
			return repository.findByJanruCd(code);
		}
}
