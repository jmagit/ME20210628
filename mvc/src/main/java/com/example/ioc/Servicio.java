package com.example.ioc;

import java.util.List;

public interface Servicio {

	List<Entidad> get();

	Entidad get(int id);

	void add(Entidad item);

	void modify(Entidad item);

	void remove(int id);

}