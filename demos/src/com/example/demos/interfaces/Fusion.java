package com.example.demos.interfaces;

public interface Fusion extends Alimentarse, Grafico {

	@Override
	default void cerrar() {
		// TODO Auto-generated method stub
		Alimentarse.super.cerrar();
	}

}
