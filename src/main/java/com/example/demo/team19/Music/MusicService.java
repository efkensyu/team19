package com.example.demo.team19.Music;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MusicService {
		private final MusicRepository repository;
		
		public List<Music> findAll(){
			return repository.findAll();
		}
		
		public List<Music> findNm(String code){
		//	return repository.findByBumonCd(code);
			return repository.findByMusicCd(code);
		}
}
