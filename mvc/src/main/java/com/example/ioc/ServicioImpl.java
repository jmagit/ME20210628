package com.example.ioc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class ServicioImpl implements Servicio {
//	@Autowired
//	@Qualifier("Verdad")
	private Repositorio dao;
	
//	@Qualifier("Verdad")
	public ServicioImpl(Repositorio dao) {
		this.dao = dao;
		System.out.println("Creo instancia");
	}
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
