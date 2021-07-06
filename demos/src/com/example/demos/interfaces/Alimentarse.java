package com.example.demos.interfaces;

public interface Alimentarse {
	public static final String HORA_DEL_CAFE = "11:15";
	
	void tomarCafe();
	void comer();
	
	default void comidaCompleta() {
		comer();
		tomarCafe();
	}
	default void cerrar() { System.out.println("Cierro comida"); }
}
