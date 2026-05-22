package com.example.demo.team19;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes(types= {Team19Form.class, Team19CommentForm.class,Team19RegisterForm.class})
//@SessionAttributes(types=Team19CommentForm.class)
public class Team19Controller {
	List<Team19RegisterForm> registerlist = new ArrayList<>();
	
	//名前セッション定義
	@ModelAttribute("team19Form")
	public Team19Form setup() {
		return new Team19Form();
	}
	//名前セッション定義
		@ModelAttribute("team19CommentForm")
		public Team19CommentForm setupComment() {
			return new Team19CommentForm();
		}
		
	//registerform
	@ModelAttribute("team19RegisterForm")
		public Team19RegisterForm setupRegister() {
		    return new Team19RegisterForm();
		}	
	
	//最初にアクセスした時
	@GetMapping("/team19")
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
	public String sendforward2() {
		return "team19/Team19Result";
	}
	
	//結果表示から、気分・ジャンル選択画面に戻るボタン
	@PostMapping(value="/team19_3", params="back")
	public String sendback2() {
		return "team19/Team19Mood_Janru";
	}
	
	//結果表示画面で、コメント登録ボタン
	@PostMapping(value="/team19_3", params="submit")
	public String submit(@ModelAttribute @Validated Team19Form team19Form,BindingResult result) {
		return "team19/Team19Result";
	}
	
	
	//結果表示から、登録画面に行くボタン
		@PostMapping(value="/team19_3", params="register")
		public String sendregister() {
			return "team19/Team19Register";
		}
		
	//曲追加ボタン
	@PostMapping(value="/team19_4", params="add")
	public String add(@ModelAttribute @Validated Team19RegisterForm team19RegisterForm,BindingResult result,Model model,SessionStatus sessionStatus) {
		if(result.hasErrors()) {
			model.addAttribute("team19RegisterForm",new Team19RegisterForm());
			return "team19/Team19Register";
		}
		registerlist.add(team19RegisterForm);
		model.addAttribute("team19RegisterForm",new Team19RegisterForm());
		model.addAttribute("result",registerlist);
		return "team19/Team19Register";
	}
	
	//曲登録画面の「削除」ボタン
	@PostMapping(value="/team19_4", params="clear")
	public String clear(@ModelAttribute Team19RegisterForm team19RegisterForm,Model model,SessionStatus sessionStatus) {
		model.addAttribute("team19RegisterForm",new Team19RegisterForm());
		registerlist.clear();
		return "team19/Team19Register";
	}
	
	//曲登録確定ボタン
	@PostMapping(value="/team19_4", params="register")
	public String send5(@ModelAttribute @Validated Team19RegisterForm team19RegisterForm,BindingResult result, Model model,SessionStatus sessionStatus) {
		if(result.hasErrors()) {
			model.addAttribute("team19RegisterForm",new Team19RegisterForm());
			return "team19/Team19Register";
		}
		
		sessionStatus.setComplete();
		model.addAttribute("result", registerlist);
		return "team19/Team19RegisterResult";
	}
	
	
	//曲登録画面からホーム画面へ戻るボタン
	@PostMapping(value="/team19_4", params="back")
	public String sendback5() {
		registerlist.clear();
		return "team19/Team19Home";
	}
}

	