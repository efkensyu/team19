package com.example.demo.team19;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team19Controller {

	@GetMapping("/team19")
	public String  index() {
		return "team19/Team19Top";
	}
	
	@PostMapping("/team19_1")
	public String send1() {
		return "team19/Team19Main";
	}
	
	@PostMapping(value="/team19_1",params="register")
	public String send4() {
		return "team19/Team19Register";
	}
	@PostMapping("/team19_2")
	public String send2() {
		return "team19/Team19Sub";
	}
	@PostMapping(value="/team19_2", params="back")
	public String sendback2() {
		return "team19/Team19Top";
	}
	
	@PostMapping("/team19_3")
	public String send3() {
		return "team19/Team19Result";
	}
	
	@PostMapping(value="/team19_3", params="back")
	public String sendback3() {
		return "team19/Team19Main";
	}

	
}
	