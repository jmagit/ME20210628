package com.example.presentations.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domains.contracts.ActorService;
import com.example.domains.entities.Actor;
import com.example.domains.exceptions.NotFoundException;

@Controller
@RequestMapping(path = "/actores")
public class ActorController {
	@Autowired
	ActorService dao;

	@GetMapping
	public String list(Model model, @PageableDefault(size = 10, sort = { "firstName", "lastName" }) Pageable pageable) {
		Page<Actor> rslt = dao.getAll(pageable);
		model.addAttribute("listado", rslt.getContent());
		model.addAttribute("rslt", rslt);
		return "actor/list";
	}

	@GetMapping("/{id}")
	public String get(@PathVariable("id") int id, Model model) throws NotFoundException {
		model.addAttribute("elemento", dao.getOne(id));
		return "actor/view";
	}

}
