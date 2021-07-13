package com.example.domains.contracts;

import java.util.List;

import com.example.domains.exceptions.InvalidDataException;
import com.example.domains.exceptions.NotFoundException;

public interface DomainService<T> {
	List<T> getAll();
	T getOne(int id) throws NotFoundException;
	void add(T item) throws InvalidDataException;
	void modify(T item) throws InvalidDataException, NotFoundException;
	void remove(T item) throws InvalidDataException;
	void removeById(int id);
}
