package com.example.demo.team19.Music;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, String> {
	public List<Music> findByMusicCd(String code);
}
