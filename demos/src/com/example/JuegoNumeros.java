package com.example;

import java.util.Random;

public class JuegoNumeros {
	private Random rnd = new Random();
	private int numeroBuscado = rnd.nextInt(100);
	private int intentos = 0;
	private boolean encontrado = false;

	public int getIntentos() { return intentos; }
	public int getNumeroBuscado() { return numeroBuscado; }
	
	public boolean deboSeguir() { return intentos < 10 && !encontrado; }
	public boolean heGanado() { return encontrado; }
	
	public void inicializa() {
		rnd = new Random();
		numeroBuscado = rnd.nextInt(100);
		intentos = 0;
		encontrado = false;
	}

	public String juega(int numeroIntroducido) {
		intentos += 1;
		String msg = "Encontrado";
		if (numeroBuscado == numeroIntroducido) {
			encontrado = true;
		} else if (numeroBuscado > numeroIntroducido) {
			 msg = "Mi número es mayor.";
		} else {
			 msg = "Mi número es menor.";
		}
		return msg;
	}


}
