package com.example.demo.team19.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team19.Repository.Team19Repository;
import com.example.demo.team19.entity.Bumon;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class team19Service {
		private final Team19Repository repository;
		
		public List<Bumon> findAll(){
			return repository.findAll();
		}
		
		public List<Bumon> findNm(String code){
		//	return repository.findByBumonCd(code);
			return repository.findByBumonCd(code);
		}
}
