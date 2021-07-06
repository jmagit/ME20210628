package com.example.demos.interfaces;

public interface Grafico {
	void pintate();
	
	default void cerrar() { System.out.println("Cierro pintado"); }
}
