package com.example;

public class Alumno extends Persona implements Grafico {
	int nota;
	
	public Alumno() {
		super(1, "anonimo");
	}
	public Alumno(int id, String nombre, int nota) {
		super(id, nombre);
	}
	
	public void suspende() {
		nota = 0;
	}
	@Override
	public void jubilate() {
		// TODO Auto-generated method stub
		super.jubilate();
	}
	@Override
	public void firma() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void comer() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void pintate() {
		// TODO Auto-generated method stub
		
	}
}
