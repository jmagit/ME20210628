package com.example.presentations.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import com.example.domains.contracts.ActorService;
import com.example.domains.entities.Actor;
import com.example.domains.exceptions.InvalidDataException;
import com.example.domains.exceptions.NotFoundException;

// http://localhost:8080/demos/params/1?nom=kk
	
@Controller
@RequestMapping(path = "/demos")
public class Demos {

	@GetMapping("/saluda")
	@ResponseBody
	public String saluda() { 
	    return "Hola mundo";
	}

	@GetMapping("/despide")
	public String despide(Model model, 
			@RequestParam(required = false, defaultValue = "") String modo) { 
		model.addAttribute("msg", "Hola mundo");
		model.addAttribute("actor", new Actor(0, "Pepito", "Grillo"));
	    return "demos" + modo;
	}

	@Autowired
	ActorService dao;
	
	@GetMapping("/otro/{id}")
	public ModelAndView otro(@PathVariable int id,
			@RequestParam(required = false, defaultValue = "") String modo) throws NotFoundException, InvalidDataException { 
		ModelAndView mv = new ModelAndView();
		mv.addObject("msg", "Datos del actor");
//		try {
			mv.addObject("actor", dao.getOne(id));
//		} catch (NotFoundException e) {
//			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//		}
		switch (modo) {
		case "":
			mv.setViewName("demos");
			break;
		case "2":
			mv.setViewName("demos2");
			break;
		default:
			mv.setViewName("redirect:/demos/saluda");
			break;
		case "error":
			throw new InvalidDataException("Esto es un error forzado");
		case "excepcion":
			throw new NullPointerException("Esto es un error forzado");
		}
		return mv;
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
