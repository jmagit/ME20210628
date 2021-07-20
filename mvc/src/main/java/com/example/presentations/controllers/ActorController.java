package com.example.presentations.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.domains.contracts.ActorService;
import com.example.domains.entities.Actor;
import com.example.domains.exceptions.InvalidDataException;
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
		model.addAttribute("page", rslt);
		return "actor/list";
	}

	@GetMapping("/{id}")
	public String get(@PathVariable("id") int id, Model model) throws NotFoundException {
		model.addAttribute("elemento", dao.getOne(id));
		return "actor/view";
	}
	
	@GetMapping("/add")
	public String add(Model model) {
		model.addAttribute("action", "actores/add");
		model.addAttribute("elemento", new Actor());
		return "actor/form";
	}
	@PostMapping("/add")
	public ModelAndView addPost(@ModelAttribute("elemento") @Valid Actor item, BindingResult result) throws InvalidDataException {
		ModelAndView mv = new ModelAndView();
		if (result.hasErrors()) {
			mv.addObject("action", "actores/add");
			mv.addObject("elemento", item);
			mv.setViewName("actor/form");
		} else {
			dao.add(item);
			mv.setViewName("redirect:/actores");
		}
		return mv;
	}

	@GetMapping("/{id}/edit")
	public String edit(@PathVariable("id") int id, Model model) throws NotFoundException {
		Actor item = dao.getOne(id);
		model.addAttribute("action", "actores/" + id + "/edit");
		model.addAttribute("elemento", item);
		return "actor/form";
	}
	@PostMapping("/{id}/edit")
	public String editPost(@PathVariable("id") int id, @ModelAttribute("elemento") @Valid Actor item, BindingResult result, Model model) throws InvalidDataException, NotFoundException {
		if(id != item.getActorId())
			result.addError(new FieldError("elemento", "actorId", "No coincide la clave"));
		if (result.hasErrors()) {
			model.addAttribute("action", "actores/" + id + "/edit");
			model.addAttribute("elemento", item);
			return "actor/form";
		} else {
			dao.modify(item);
			return "redirect:/actores";
		}
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable("id") int id, Model model) {
		try {
			dao.removeById(id);
		} catch (Exception e) {
		}
		return "redirect:/actores";
	}


}
