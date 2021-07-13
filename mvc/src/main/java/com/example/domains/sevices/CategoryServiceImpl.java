package com.example.domains.sevices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.domains.contracts.CategoryService;
import com.example.domains.entities.Category;
import com.example.domains.exceptions.InvalidDataException;
import com.example.domains.exceptions.NotFoundException;
import com.example.infraestructure.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository dao;
	
	public CategoryServiceImpl() {
	}

	@Override
	public List<Category> getAll() {
		return dao.findAll();
	}

	@Override
	public Category getOne(Integer id) throws NotFoundException {
		var item = dao.findById(id);
		if(item.isEmpty())
			throw new NotFoundException();
		return item.get();
	}

	@Override
	public void add(Category item) throws InvalidDataException {
		if(item == null || item.isInvalid())
			throw new InvalidDataException(item == null ? "Faltan los datos" : item.getErrorsMessage());
		if(dao.findById(item.getCategoryId()).isPresent())
			throw new InvalidDataException("Clave duplicada");
		dao.save(item);
	}

	@Override
	public void modify(Category item) throws InvalidDataException, NotFoundException {
		if(item == null || item.isInvalid())
			throw new InvalidDataException(item == null ? "Faltan los datos" : item.getErrorsMessage());
		if(dao.findById(item.getCategoryId()).isEmpty())
			throw new NotFoundException();
		dao.save(item);
	}

	@Override
	public void remove(Category item) throws InvalidDataException, NotFoundException {
		if(item == null)
			throw new InvalidDataException("Faltan los datos");
		removeById(item.getCategoryId());
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
