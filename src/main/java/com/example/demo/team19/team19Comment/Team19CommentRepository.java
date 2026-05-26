package com.example.demo.team19.team19Comment;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface Team19CommentRepository extends JpaRepository<Team19Comment, Integer> {
	
	@Query(value = "select * from team19_comment_tbl where music_cd in (select music_cd from team19_music_tbl msc join team19_janru_tbl j on msc.janru_cd = j.janru_cd join team19_kibun_tbl m on msc.mood_cd = m.mood_cd where j.janru_nm = :janru and m.mood_nm = :mood)", nativeQuery =true)
	public List<Team19Comment> selectComment(@Param("mood") String mood, @Param("janru") String janru);
	
//	@Modifying
//	@Transactional
//	@Query(value ="insert into team19_comment_tbl (comment_date, music_cd, comment_text) select :date, m.music_cd, :text from team19_music_tbl m where m.music_nm = :musicNm",  nativeQuery = true)
//	public void insertComment(@Param("date") LocalDate date, @Param("musicNm") String musicNm ,@Param("text") String text) ;
	
	@Modifying
	@Transactional
	@Query(value ="INSERT INTO team19_comment_tbl (comment_date, music_cd, comment_text) " +
	              "VALUES (:date, :musicCd, :text)",
	       nativeQuery = true)
	public void insertComment(@Param("date") Date date,
	                   @Param("musicCd") Integer musicCd,
	                   @Param("text") String text);
	
	@Query(value = """
			select c.*
			from team19_comment_tbl c
			join team19_music_tbl m
			  on c.music_cd = m.music_cd
			where m.music_nm like %:musicNm%
			""",nativeQuery = true)
	List<Team19Comment> selectCommentByMusicNm(
			@Param("musicNm")String musicNm);

}
