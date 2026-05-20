package com.example.demo.team19;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class Team19Controller {

	@GetMapping("/team19")
	public String  index() {
		return "Team19Top";
	}
	
	@PostMapping("/team19")
	public String send() {
		return "Team19Main";
	}
}
	