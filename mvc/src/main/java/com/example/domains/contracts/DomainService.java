package com.example.domains.contracts;

import java.util.List;

import com.example.domains.core.Entidad;
import com.example.domains.exceptions.InvalidDataException;
import com.example.domains.exceptions.NotFoundException;

public interface DomainService<T extends Entidad<T>, K> {
	List<T> getAll();
	T getOne(K id) throws NotFoundException;
	void add(T item) throws InvalidDataException;
	void modify(T item) throws InvalidDataException, NotFoundException;
	void remove(T item) throws InvalidDataException, NotFoundException;
	void removeById(K id) throws NotFoundException;
}
