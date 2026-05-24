package com.example.demo.team19.team19Music;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class Team19MusicService {
		private final Team19MusicRepository repository;
		
		public List<Team19Music> findAll(){
			return repository.findAll();
		}
		
		public List<Team19Music> findMusic(String mood, String janru){
		//	return repository.findByBumonCd(code);
			return repository.findMusic(mood, janru);
		}
		
		public void insertMusic(String name, String artist, String janru, String url, String mood){
			repository.insertMusic(name, artist, janru, url, mood);
		}
		
}
