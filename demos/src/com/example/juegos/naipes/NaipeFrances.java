package com.example.juegos.naipes;

import com.example.juegos.JuegoException;

public class NaipeFrances extends Naipe<NaipeFrances.Palos> {
	public static enum Palos { CORAZONES, DIAMANTES, TREBOLES, PICAS }
	public static final int CARTASxPALO = 13;
	public static final String[] LITERALES = {"Comodin", "As", "Dos", "Tres", 
			"Cuatro", "Cinco", "Seis", "Siete", "Ocho", "Nueve", "Diez",
			"Jota", "Reina", "Rey" };
	public NaipeFrances(Palos palo, byte valor) throws JuegoException {
		super(palo, validaValor(valor));
	}
	@Override
	protected String[] getLiterales() {
		return LITERALES;
	}
	private static byte validaValor(byte valor) throws JuegoException {
		if(valor < 0 || valor > 13)
			throw new JuegoException("El valor debe estar 1 y 13");
		return valor;
	}
}
