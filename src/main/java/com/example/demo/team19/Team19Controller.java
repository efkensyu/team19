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
		return "team19/Team19Mood";
	}
	
	//登録ボタン
	@PostMapping(value="/team19_1",params="register")
	public String send4() {
		return "team19/Team19Register";
	}
	
	//気分選択
	@PostMapping("/team19_2")
	public String send2() {
		return "team19/Team19Janru";
	}
	
	//気分選択画面からホームへ戻るボタン
	@PostMapping(value="/team19_2", params="back")
	public String sendback2() {
		return "team19/Team19Home";
	}
	
	//ジャンル選択
	@PostMapping("/team19_3")
	public String send3() {
		return "team19/Team19Result";
	}
	
	//ジャンル選択画面から気分画面へ戻るボタン
	@PostMapping(value="/team19_3", params="back")
	public String sendback3() {
		return "team19/Team19Mood";
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
	