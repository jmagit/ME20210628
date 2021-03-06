package com.example.application.resources;

import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.domains.contracts.ActorService;
import com.example.domains.entities.Actor;
import com.example.domains.exceptions.BadRequestException;
import com.example.domains.exceptions.InvalidDataException;
import com.example.domains.exceptions.NotFoundException;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/actores")
public class ActorResource {
	@Autowired
	private ActorService srv;

	@GetMapping
	public Page<Actor> getAll(Pageable pageable) {
		return srv.getAll(pageable);
	}

	@GetMapping(path = "/{id}")
	public Actor getOne(@PathVariable int id) throws NotFoundException {
		return srv.getOne(id);
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void create(@Valid @RequestBody Actor item) throws BadRequestException, InvalidDataException {
		srv.add(item);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
//			.buildAndExpand(newItem.getActorId()).toUri();
//		return ResponseEntity.created(location).build();
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public void update(@PathVariable int id, @Valid @RequestBody Actor item) throws BadRequestException, NotFoundException, InvalidDataException {
		if(id != item.getActorId())
			throw new BadRequestException("No coinciden los identificadores");
		srv.modify(item);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) throws NotFoundException {
		srv.removeById(id);
	}

}
