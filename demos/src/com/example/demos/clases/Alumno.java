package com.example.demos.clases;

import com.example.demos.interfaces.Grafico;

public class Alumno extends Persona implements Grafico {
	private int nota;
	
	public Alumno() {
		super(1, "anonimo");
	}
	public Alumno(int id, String nombre, String apellidos, int nota) {
		super(id, nombre, apellidos);
		this.nota = nota;
	}
	
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
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
	@Override
	public void cerrar() {
		// TODO Auto-generated method stub
		super.cerrar();
	}
	@Override
	public String toString() {
		return "Alumno [id=" + getId() + ", nombre=" + getNombre() + ", apellidos=" + getApellidos()
				+ ", nota=" + nota + "]";
	}
	
}
