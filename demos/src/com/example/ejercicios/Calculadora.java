package com.example.ejercicios;

public class Calculadora {
	private double acumulador = 0;
	private double operando = 0;
	private String operador = "+";
	
	public Calculadora() {
		inicializar();
	}

	public void inicializar() {
		acumulador = 0;
		operador = "+";
	}
	
	public void ponOperando(String cad) {
		operando = Double.parseDouble(cad);
	}
	
	public void calcular(String operacion) {
		if("+-*/=".indexOf(operacion) < 0)
			throw new IllegalArgumentException("Operación no soportada.");
		switch (this.operador) {
		case "+":
			acumulador += operando;
			break;
		case "-":
			acumulador -= operando;
			break;
		case "*":
			acumulador *= operando;
			break;
		case "/":
			acumulador /= operando;
			break;
		case "=":
			break;
		}
		this.operador = operacion;
	}
	
	public double getResultado() {
		return acumulador;
	}
}
