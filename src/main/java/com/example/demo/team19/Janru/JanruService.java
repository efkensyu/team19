package com.example.demo.team19.Janru;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class JanruService {
		private final JanruRepository repository;
		
		public List<Janru> findAll(){
			return repository.findAll();
		}
		
		public List<Janru> findNm(String code){
		//	return repository.findByBumonCd(code);
			return repository.findByJanruCd(code);
		}
}
