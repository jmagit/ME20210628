package com.example.juegos.ajedrez;

import com.example.juegos.JuegoException;

public class Movimiento {	
	private Posicion posicionInicial;
	private Posicion posicionFinal;
	
	/**
	 * Contructor del movimiento que recibe una cadena en notaci�n internacional
	 * @param movimiento Cadena en notaci�n [A-H][1-8][A-H][1-8]
	 * @throws JuegoException Formato del movimiento invalido.
	 */
	public Movimiento(String movimiento) throws JuegoException {
		if(movimiento == null || !movimiento.matches("^([A-H][1-8]){2}$"))
			throw new JuegoException("El movimiento no est� en notaci�n internacional.");
		if(movimiento.substring(0, 1).equals(movimiento.substring(2, 3)))
			throw new JuegoException("La posici�n inicial debe ser distinta de la posici�n final.");
		posicionInicial = new Posicion(movimiento.charAt(1), movimiento.charAt(0));	
		posicionFinal = new Posicion(movimiento.charAt(3), movimiento.charAt(2));	
	}
	
	/**
	 * Contructor que recibe la posici�n inicial y final del movimiento
	 * @param posicionInicial Posici�n inicial
	 * @param posicionFinal Posici�n final
	 * @throws JuegoException Movimiento invalido
	 */
	public Movimiento(Posicion posicionInicial, Posicion posicionFinal) throws JuegoException {
		if(posicionFinal == posicionInicial)
			throw new JuegoException("La posici�n inicial debe ser distinta de la posici�n final.");
		this.posicionInicial = posicionInicial;
		this.posicionFinal = posicionFinal;
	}

	/**
	 * Obtiene la posici�n de partida del movimiento
	 * @return Posici�n inicial
	 */
	public Posicion getPosicionInicial() {
		return posicionInicial;
	}

	/**
	 * Obtiene la posici�n de llegada del movimiento
	 * @return Posici�n final
	 */
	public Posicion getPosicionFinal() {
		return posicionFinal;
	}

	/**
	 * Devuelve el numero de filas que desplaza el movimiento.
	 * @return Valor entre 0 y 8
	 */
	public int saltoVertical() {
		return Math.abs(posicionInicial.getFila() - posicionFinal.getFila());
	}

	/**
	 * Devuelve el numero de columnas que desplaza el movimiento.
	 * @return Valor entre 0 y 8
	 */
	public int saltoHorizontal() {
		return Math.abs(posicionInicial.getColumna() - posicionFinal.getColumna());
	}
	
	/**
	 * Informa si el movimiento es un desplazamiento vertical
	 * @return verdadero si es vertical
	 */
	public boolean esVertical() {
		return posicionInicial.getFila() != posicionFinal.getFila() &&
				posicionInicial.getColumna() == posicionFinal.getColumna();
	}

	/**
	 * Informa si el movimiento es un desplazamiento horizontal
	 * @return verdadero si es horizontal
	 */
	public boolean esHorizontal() {
		return posicionInicial.getFila() == posicionFinal.getFila() &&
				posicionInicial.getColumna() != posicionFinal.getColumna();
	}
	
	/**
	 * Informa si el movimiento es un desplazamiento diagonal
	 * @return verdadero si es diagonal
	 */
	public boolean esDiagonal() {
		return saltoHorizontal() == saltoVertical();
	}
	
	/**
	 * Indica la direccion vertical del movimiento
	 * @return -1 de abajo/arriba, 1 de arriba/abajo, 0 estatico
	 */
	public int deltaVertical() {
		return posicionInicial.getFila() < posicionFinal.getFila() ? -1 : 
			posicionInicial.getFila() == posicionFinal.getFila() ? 0 : 1;
	}
	
	/**
	 * Indica la direccion horizontal del movimiento
	 * @return -1 de izquierda/derecha, 1 de derecha/izquierda, 0 estatico
	 */
	public int deltaHorizontal() {
		return posicionInicial.getColumna() < posicionFinal.getColumna() ? -1 : 
			posicionInicial.getColumna() == posicionFinal.getColumna() ? 0 : 1;
	}
}
