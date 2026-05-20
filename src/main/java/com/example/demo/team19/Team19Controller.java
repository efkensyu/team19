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
	
	@PostMapping("/team19")
	public String send1() {
		return "team19/Team19Main";
	}
	@PostMapping("/team19")
	public String send2() {
		return "team19/Team19Sub";
	}
	
}
	