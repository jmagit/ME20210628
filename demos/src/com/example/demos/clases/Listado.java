package com.example.demos.clases;

public class Listado<T extends Persona> {
	private T[] lista;
	
	public Listado(T[] lista) {
		this.lista = lista;
	}
	
	public T getPrimero() { return lista[0]; }
	public void setPrimero(T valor) { lista[0] = valor; }
}
