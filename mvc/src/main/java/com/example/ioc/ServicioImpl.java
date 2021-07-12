package com.example.ioc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioImpl implements Servicio {
	@Autowired
	private Repositorio dao;
	
	@Override
	public List<Entidad> get() {
		return dao.get();
	}
	@Override
	public Entidad get(int id) {
		return dao.get(id);
	}
	@Override
	public void add(Entidad item) {
		// falta validar
		dao.add(item);
	}
	@Override
	public void modify(Entidad item) {
		// falta validar
		dao.modify(item);
	}
	@Override
	public void remove(int id) {
		dao.remove(id);
	}

	// Otras operaciones de múltiples entidades
}
