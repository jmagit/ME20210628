package com.example.demos.clases;

import com.example.Autor;

@Autor(nombre = "otro", descripcion = "es una demo")
public class Profesor extends Persona {

	public Profesor(int id, String nombre, String apellidos) {
		super(id, nombre, apellidos);
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
	public String toString() {
		return "Profesor [id=" + getId() + ",nombre=" + getNombre() + ", apellidos=" + getApellidos()
				+ "]";
	}

}
