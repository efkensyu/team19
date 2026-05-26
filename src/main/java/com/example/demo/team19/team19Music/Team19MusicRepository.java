package com.example.demo.team19.team19Music;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface Team19MusicRepository extends JpaRepository<Team19Music,Integer> {
	
	boolean existsByMusicUrl(String musicurl);
	
	@Query(value = "select music_cd, music_nm, artist, msc.janru_cd, music_Url,msc.mood_cd, like_Cnt from team19_music_tbl msc join team19_kibun_tbl m on msc.mood_cd = m.mood_cd join team19_janru_tbl j on msc.janru_cd =j.janru_cd where m.mood_nm = :mood and j.janru_nm = :janru", nativeQuery = true)
	public List<Team19Music> findMusic(@Param("mood") String mood, @Param("janru") String janru);
	
	@Query(value = "select music_nm from team19_music_tbl where music_cd = :musicCd", nativeQuery = true)
	public String disMusicNm(@Param("musicCd") Integer musicCd);
	
	@Modifying
	@Transactional
	@Query(value ="insert into team19_music_tbl (music_nm, artist, janru_cd, music_url, mood_cd, like_cnt)  select :name, :artist, j.janru_cd, :url, m.mood_cd, 0 from team19_janru_tbl j, team19_kibun_tbl m  where j.janru_nm = :janru and m.mood_nm = :mood",  nativeQuery = true)
	void insertMusic(
	        @Param("name") String name,
	        @Param("artist") String artist,
	        @Param("janru") String janru,
	        @Param("url") String url,
	        @Param("mood") String mood
	);

}

