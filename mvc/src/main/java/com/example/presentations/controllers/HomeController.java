package com.example.presentations.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping
	public String index() {
		return "home";
	}
	
	@GetMapping("/ajax")
	public String ajax() {
		return "ajax";
	}
}
