package com.example.domains.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.domains.contracts.ActorService;
import com.example.domains.entities.Actor;
import com.example.domains.exceptions.InvalidDataException;
import com.example.domains.exceptions.NotFoundException;
import com.example.infraestructure.repositories.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService {
	@Autowired
	ActorRepository dao;
	
	public ActorServiceImpl() {
	}

	@Override
	public List<Actor> getAll() {
		return dao.findAll();
	}

	@Override
	public Page<Actor> getAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public Actor getOne(Integer id) throws NotFoundException {
		var item = dao.findById(id);
		if(item.isEmpty())
			throw new NotFoundException();
		return item.get();
	}

	@Override
	public void add(Actor item) throws InvalidDataException {
		if(item == null || item.isInvalid())
			throw new InvalidDataException(item == null ? "Faltan los datos" : item.getErrorsMessage());
		if(dao.findById(item.getActorId()).isPresent())
			throw new InvalidDataException("Clave duplicada");
		dao.save(item);
	}

	@Override
	public void modify(Actor item) throws InvalidDataException, NotFoundException {
		if(item == null || item.isInvalid())
			throw new InvalidDataException(item == null ? "Faltan los datos" : item.getErrorsMessage());
		if(dao.findById(item.getActorId()).isEmpty())
			throw new NotFoundException();
		dao.save(item);
	}

	@Override
	public void remove(Actor item) throws InvalidDataException, NotFoundException {
		if(item == null)
			throw new InvalidDataException("Faltan los datos");
		removeById(item.getActorId());
	}

	@Override
	public void removeById(Integer id) throws NotFoundException {
		try {
			dao.deleteById(id);		
		} catch (EmptyResultDataAccessException e) {
			throw new NotFoundException(e);
		}
	}

}
