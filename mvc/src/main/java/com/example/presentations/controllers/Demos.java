package com.example.presentations.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// http://localhost:8080/demos/params/1?nom=kk
	
@Controller
@RequestMapping(path = "/demos")
public class Demos {

	@GetMapping("/saluda")
	@ResponseBody
	public String saluda() { 
	    return "Hola mundo";
	}

	@GetMapping("/params/{id}")
	@ResponseBody
	public String cotilla(
	        @PathVariable String id,
	        @RequestParam String nom,
	        @RequestHeader("Accept-Language") String language, 
	        @CookieValue(name = "JSESSIONID", required = false, defaultValue = "(sin sesion)" ) String cookie,
	        Model model) { 
	    StringBuilder sb = new StringBuilder();
	    sb.append("id: " + id + "<br>");
	    sb.append("nom: " + nom + "<br>");
	    sb.append("language: " + language + "<br>");
	    sb.append("cookie: " + cookie + "<br>");
	    //model.addAttribute("message", sb.toString());
	    //return "message";
	    return sb.toString();
	}

}
