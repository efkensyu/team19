package com.example.demo.team19;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.team19.team19Music.Team19MusicService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes(types= {Team19Form.class, Team19CommentForm.class,Team19CommentForm2.class,Team19RegisterForm.class})
public class Team19Controller2 {
	List<Team19RegisterForm> registerlist = new ArrayList<>();
	List<Team19CommentForm2> comeList = new ArrayList<>();
	private final Team19MusicService musicService;
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
		
		//URL変換
		public static String toEmbedUrl(String url) {
		    String base = url.split("\\?si=")[0];
		    base = base.replace("/intl-ja/", "/embed/");
		    return base;
		}
		//URL到達可能チェック！
		public static boolean isReachable(String urlString) {
		    try {
		        URL url = new URL(urlString);
		        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		        conn.setRequestMethod("GET");
		        conn.setConnectTimeout(3000);
		        conn.setReadTimeout(3000);
		        //そもそも到達出来るURLなのか判断！
		        int status = conn.getResponseCode();
		        if (status < 200 || status >= 400) {
		            return false;
		        }

		        // HTML を少し読む
		        try (BufferedReader reader = new BufferedReader(
		                new InputStreamReader(conn.getInputStream()))) {
		        	//以下の文面がWebページに表示されていないかチェック！
		            String line;
		            while ((line = reader.readLine()) != null) {
		                if (line.contains("お探しの曲が見つかりませんでした")
		                    || line.contains("Page not found")
		                    || line.contains("not found")) {
		                    return false;
		                }
		            }
		        }

		        return true;

		    } catch (Exception e) {
		        return false;
		    }
		}


		
		
	//曲追加ボタン
		@PostMapping(value="/team19_4", params="add")
		public String add(@ModelAttribute @Validated Team19RegisterForm team19RegisterForm,BindingResult result,Model model,SessionStatus sessionStatus) {
			if(result.hasErrors()) {
				//model.addAttribute("team19RegisterForm",new Team19RegisterForm());
				model.addAttribute("result",registerlist);				
				return "team19/Team19Register";
			}
			//撃ち込まれたURLが再生可能か判断！
			boolean reach = isReachable(toEmbedUrl(team19RegisterForm.getUrl()));
			if(!reach) {
				result.reject(
						"duplicateUrl",
						"不正なURLです");
				model.addAttribute("result",registerlist);
				return "team19/Team19Register";
			}
			
			List<String> urls = musicService.urlList();
			boolean exists = false;
			for (String url : urls) {
				if(toEmbedUrl(team19RegisterForm.getUrl()).equals(toEmbedUrl(url))) {
				exists = true;
				}
			}
			
			if(exists) {
				result.reject(
						"duplicateUrl",
						"この曲は既に登録されています"
					);
				
				model.addAttribute("result",registerlist);
				
				return "team19/Team19Register";
			}
			
			for(Team19RegisterForm d : registerlist) {
				
				if(d.getUrl().equals(team19RegisterForm.getUrl())) {
					
					result.reject(
							"duplicateListUrl",
							"この曲は既にリストへ追加されています");
				
				
				model.addAttribute("result", registerlist);
				
				return "team19/Team19Register";
				}
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
		public String send5(@ModelAttribute Team19RegisterForm team19RegisterForm,BindingResult result, Model model,SessionStatus sessionStatus) {
			if(registerlist == null || registerlist.isEmpty()) {
				result.reject("emptyList", "登録データがありません");
				return "team19/Team19Register";
			}
			
			List<String> urls = musicService.urlList();
			boolean exists = false;
			
			for (Team19RegisterForm d : registerlist) {
				for (String url : urls) {
					if(toEmbedUrl(d.getUrl()).equals(toEmbedUrl(url))) {
					exists = true;
					}
				}
				
				if(exists) {
					result.reject(
							"duplicateUrl",
							"URL「" + d.getUrl() + "」は既に登録済みです。"
							);
							model.addAttribute("result", registerlist);
							return "team19/Team19Register";
				}			
			}
			
			//テーブル追加処理
			for(Team19RegisterForm d : registerlist) {
				musicService.insertMusic(d.getMusicNm(), d.getArtist(), d.getJanru(), d.getUrl(), d.getMood());
			}
			//セッションのリフレッシュ
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


	