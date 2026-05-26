package com.example.demo.team19;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team19.team19Comment.Team19Comment;
import com.example.demo.team19.team19Comment.Team19CommentService;
import com.example.demo.team19.team19Music.Team19Music;
import com.example.demo.team19.team19Music.Team19MusicService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes(types= {Team19Form.class, Team19CommentForm.class,Team19CommentForm2.class,Team19RegisterForm.class})
public class Team19Controller {
	List<Team19RegisterForm> registerlist = new ArrayList<>();
	List<Team19CommentForm2> comeList = new ArrayList<>();
	private final Team19MusicService musicService;
	private final Team19CommentService musicComment;
	
	//名前セッション定義
	@ModelAttribute("team19Form")
	public Team19Form setup() {
		return new Team19Form();
	}
	//コメントセッション定義
		@ModelAttribute("team19CommentForm")
		public Team19CommentForm setupComment() {
			return new Team19CommentForm();
		}
		
	//登録セッション定義
	@ModelAttribute("team19RegisterForm")
		public Team19RegisterForm setupRegister() {
		    return new Team19RegisterForm();
		}	
	
	//最初にアクセスした時
	@GetMapping("team19")
	public String  index() {
		return "team19/Team19Home";
	}
	
	//ようこそボタン
	@PostMapping("/team19_1")
	public String send1(@ModelAttribute @Validated Team19Form team19Form,BindingResult result) {
		
		if(result.hasErrors()) {
			return "team19/Team19Home";
		}
		return "team19/Team19Mood_Janru";
	}
	
	//登録ボタン
	@PostMapping(value="/team19_1",params="register")
	public String send4() {
		return "team19/Team19Register";
	}
	
	//気分・ジャンル選択
	@PostMapping("/team19_2")
	public String send2() {
		return "team19/Team19Mood_Janru";
	}
	
	//気分・ジャンル選択画面からホームへ戻るボタン
	@PostMapping(value="/team19_2", params="back")
	public String sendback1() {
		return "team19/Team19Home";
	}
	
	//resetボタン
	@PostMapping(value="/team19_2", params="reset")
	public String reset() {
		return "team19/Team19Mood_Janru";
	}
	
	//気分・ジャンル選択画面から結果表示に行くボタン
	@PostMapping(value="/team19_2", params="forward")
	public String sendforward2(@RequestParam("mood") String mood,
			@RequestParam("janru") String janru, Model model) {
		//曲一覧作成
		List<Team19Music> musicList = musicService.findMusic(mood, janru);
		//コメント一覧作成(ムード、ジャンル絞り)
		List<Team19Comment> commentList = musicComment.findAll();
		
		comeList = new ArrayList<>();
		
		for (Team19Comment d : commentList) {
	        comeList.add(  new Team19CommentForm2( d.getCommentDate(), musicService.disMusicNm(d.getMusicCd()), d.getCommentText()) );
	    }
		
		model.addAttribute("mood", mood);
		model.addAttribute("janru",janru);
		//楽曲一覧表示
		model.addAttribute("musicList", musicList);
		//コメント一覧表示
		model.addAttribute("comeList", comeList);
		
		return "team19/Team19Result";
	}
	
	//結果表示から、気分・ジャンル選択画面に戻るボタン
	@PostMapping(value="/team19_3", params="back")
	public String sendback2() {
		return "team19/Team19Mood_Janru";
	}
	
	//結果表示画面で、コメント登録ボタン
	@PostMapping(value="/team19_3", params="submit")
	public String submit(
	        @RequestParam("mood") String mood,
	        @RequestParam("janru") String janru,
	        @ModelAttribute Team19Form team19Form,
	        @ModelAttribute @Validated Team19CommentForm team19CommentForm,
	        BindingResult result, Model model) {
		List<Team19Music> musicList = musicService.findMusic(mood, janru);
		
		if (result.hasErrors()) {
			model.addAttribute("mood", mood);
		    model.addAttribute("janru", janru);
		    model.addAttribute("comeList", comeList);
		    model.addAttribute("musicList", musicList);
			 return "team19/Team19Result";
		}
	    
	    Date date = new Date(System.currentTimeMillis());

	    

	    // ★ 曲IDで登録
	    
	    model.addAttribute("mood", mood);
	    model.addAttribute("janru", janru);
	    model.addAttribute("musicList", musicList);
	    model.addAttribute("team19CommentForm",new Team19CommentForm());
	    
	    
	    comeList.add(new Team19CommentForm2( date, musicService.disMusicNm(team19CommentForm.getMusicCd()), team19CommentForm.getComment()) );
	    musicComment.insertComment(
	            date,team19CommentForm.getMusicCd(),team19CommentForm.getComment()
	            );	    
	    
	    model.addAttribute("comeList", comeList);
	    
	    
	    return "team19/Team19Result";
	}

	
	
	//結果表示から、登録画面に行くボタン
		@PostMapping(value="/team19_3", params="register")
		public String sendregister() {
			return "team19/Team19Register";
		}
		
}
	