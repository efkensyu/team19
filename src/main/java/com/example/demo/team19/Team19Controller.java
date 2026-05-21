package com.example.demo.team19;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team19Controller {
	//最初にアクセスした時
	@GetMapping("/team19")
	public String  index() {
		return "team19/Team19Home";
	}
	
	//ようこそボタン
	@PostMapping("/team19_1")
	public String send1() {
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
	
	//気分・ジャンル選択画面から結果表示に行くボタン
	@PostMapping(value="/team19_2", params="forward")
	public String sendforward2() {
		return "team19/Team19Result";
	}
	
	//結果表示から、気分・ジャンル選択画面に戻るボタン
	@PostMapping(value="/team19_3", params="back")
	public String sendback2() {
		return "team19/Team19Mood_Janru";
	}
	
	//結果表示から、登録画面に行くボタン
		@PostMapping(value="/team19_3", params="register")
		public String sendregister() {
			return "team19/Team19Register";
		}
	
	//曲追加ボタン
	@PostMapping(value="/team19_4", params="add")
	public String add() {
		return "team19/Team19Register";
	}
	
	//曲登録確定ボタン
	@PostMapping(value="/team19_4", params="register")
	public String send5() {
		return "team19/Team19Register";
	}
	
	
	//曲登録画面からホーム画面へ戻るボタン
	@PostMapping(value="/team19_4", params="back")
	public String sendback5() {
		return "team19/Team19Home";
	}
	
	
}
	