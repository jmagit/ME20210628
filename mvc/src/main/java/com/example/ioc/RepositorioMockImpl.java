package com.example.ioc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

//@Repository
//@Qualifier("Mentira")
public class RepositorioMockImpl implements Repositorio {
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
		System.out.println("Falsa");
	}
	@Override
	public void modify(Entidad item) {
		System.out.println("Falsa");
	}
	@Override
	public void remove(int id) {
		System.out.println("Falsa");
	}

}
