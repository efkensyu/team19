package com.example.demo.team19;

import org.springframework.web.bind.annotation.GetMapping;

public class Team19Controller {

	@GetMapping("/team19")
	public String  index() {
		return "Team19Main";
	}
	
}