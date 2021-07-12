package com.example.ioc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class RepositorioImpl implements Repositorio {
	@Override
	public List<Entidad> get() {
		return new ArrayList<>();
	}
	@Override
	public Entidad get(int id) {
		return new Entidad();
	}
	@Override
	public void add(Entidad item) {
		System.out.println("La he añadido");
	}
	@Override
	public void modify(Entidad item) {
		System.out.println("La he modificado");
	}
	@Override
	public void remove(int id) {
		System.out.println("La he borrado");
	}
}
