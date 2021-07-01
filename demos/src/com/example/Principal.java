package com.example;

import java.sql.Array;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Clase lanzadora de los ejemplos del curso de Java
 * 
 * @author Javier
 *
 */
public class Principal {

	/**
	 * Metodo inicial de la aplicacion
	 * 
	 * @param args Linea de comandos
	 */
	public static void main(String[] args) {
		//juega();
		//calcula("3+4+3,4-7*1=");
		//calculaRegEx("3+4+3,4-7*1=");
		ejemplos3();

	}
	public static void ejemplos3() {
		//Persona p = new Persona(1, "Pepito");
	}
	public static void ejemplos2() {
		Genero genero = Genero.DESCONOCIDO;
		if(genero == Genero.FEMENINO) {
			
		}
		
		Principal principal = new Principal();
		int i = 1, j = 2;
		principal.suma((double)i, j);
//		principal.suma();
//		principal.suma(1);
		double rslt = principal.suma("2", "2") +
		principal.suma(1, 2, principal.suma((double)i, j), 4, 5) * 4;
		Persona p = new Alumno();
		if(p instanceof Alumno)
			((Alumno)p).suspende();
		p.getFechaNacimiento().setYear(2030);
		Grafico a = null;
		a = new Figura();
		a = new Alumno();
		a.pintate();
		Object object = new Profesor(1,	"Profe");
		if(object instanceof Grafico) {
			((Grafico)object).pintate();
		}
		//p.nombre="kk";
		Servicio srv = new Circulo();
	}
	
	public double suma(double a, double b, double... lst) {
		double rslt = a + b;
		for(double valor: lst) {
			// if(rslt > 100) return 100;
			rslt += valor;
		}
		return rslt;
	}
	public double suma(int a, int b) {
		return a + b;
	}
	public double suma(double a, double b) {
		return a + b;
	}
	public double suma(String a, String b) {
		return suma(Double.parseDouble(a), Double.parseDouble(b));
	}

	public static void ejemplos1() {
//		int i, j;
//		var x = "algo";
//		long l = 4;
//		Object object = null;
//
//		i = (int) l;
//		l = 4L;
//		j = 0;
//		int[] t = new int[7];
//		i = t[0];
//		t[0] = 1;
//		t[1] = 2;
//		t[2] = 3;
//		i = 0;
//		while (t[i] == 0 && ++i < t.length)
//			;
//		i = 1;
//		j = i++;
//		i = t.length;
//		int tt[] = { 1, 2, 3 };
//		tt = t;
//		tt[0] = 7;
//		++i;
//		char sexo = 'h';
//		double total, precio = 1, descuento = 0.2;
//		x = "persona" + (i > 1 ? "s" : "");
//		total = precio - (sexo == 'm' ? precio * 2 * descuento : -10);
//
//		total = precio - switch (sexo) {
//		case 'm', 'n':
//			yield precio * 2 * descuento;
//		case 'h':
//			yield -10;
//		case 'l':
//			yield -5;
//		default:
//			// ...
//			yield 0;
//		} + 2;
//		total = precio - switch (sexo) {
//		case 'm', 'n' -> precio * 2 * descuento;
//		case 'h' -> -10;
//		case 'l' -> -5;
//		default -> 0;
//		} + 2;
//
//		for (var indice = 0; indice < t.length; indice++) {
//			t[indice] = 0;
//		}
//		var indice = 0;
//
//		etiqueta: while (indice < t.length) {
//			t[indice] = 0;
//			dos: while (en.hasMoreElements()) {
//				type type = (type) en.nextElement();
//				if (t[indice] == 100)
//					break etiqueta;
//				while (en.hasMoreElements()) {
//					type type = (type) en.nextElement();
//					if (t[indice] == 100)
//						break dos;
//
//				}
//
//			}
//			if (t[indice] == 100)
//				continue;
//			indice++;
//		}
//		if (t != null && i < t.length) {
//			// s += "x"
//		}
//		if (i > 0) {
//			j = 0;
//			if (i == 0) {
//				j = -1;
//			} else
//				j = +1;
//		}
//		boolean b = true;
//		// ...
//		if (!b) {
//
//		}
//
//		j = 0; // i == 3
//		switch (i) {
//		case 5:
//		default:
//			x = "no se";
//			j += 2;
//		case 3:
//			j += 2;
//		case 1:
//			j += 1;
//			x = "impar";
//			break;
//		case 2:
//		case 4:
//		case 6:
//			x = "par";
//			break;
//		case 10:
//			x = "diez";
//
//		}
//
//		t = null;
//
//		int[][] tablero = new int[8][8];
//		if (object instanceof String) {
//			String kk = ((String) object);
//		}
//		System.out.println(j);
//		System.out.println("Hola miranda");
//		juega();
	}

	private static java.util.Scanner teclado = new java.util.Scanner(System.in);

	private static String leer() {
		return teclado.nextLine();
	}

	public static void juega() {
		do {
			var rnd = new Random();
			int numeroBuscado = rnd.nextInt(100);
			int numeroIntroducido;
			int intentos = 0;
			boolean encontrado = false;
			// System.out.print("El n�mero: " + numeroBuscado);
			do {
				try {
					System.out.print("Dame tu n�mero (" + (intentos + 1) + " de 10): ");
					numeroIntroducido = Integer.parseInt(leer());
					intentos += 1;
					if (numeroBuscado == numeroIntroducido) {
						encontrado = true;
					} else if (numeroBuscado > numeroIntroducido) {
						System.out.println("Mi n�mero es mayor.");
					} else {
						System.out.println("Mi n�mero es menor.");
					}
				} catch (Exception ex) {
					// System.out.println("No es un n�mero valido.");
				}
			} while (intentos < 10 && !encontrado);

			if (encontrado) {
				System.out.println("Bieeen!!! Acertaste.");
			} else {
				System.out.println("Upsss! Se acabaron los intentos, el n�mero era el " + numeroBuscado);
			}
			System.out.println("�Otra? [S/N]");
		} while ("s".compareToIgnoreCase(leer()) == 0);
	}

	public static double calcula(String expresion) {
		String operando = "";
		
		//"([0-9,]+)|([+-/*=])"
		for (int i = 0; i < expresion.length(); i++) {
			char ch = expresion.charAt(i);
			if (Character.isDigit(ch)) { // '0' <= ch && ch <='9'
				operando += ch;
			} else if (ch == ',') {
				if (operando.indexOf(ch) == -1) {
					operando += '.';
				} else {
					// throw new Exception("Ya existe separador decimal.");
				}
			} else if ("+-*/%=".indexOf(ch) >= 0) {
				if (operando.endsWith(",")) {
					operando += "0";
				}
				System.out.println(operando + " " + ch);
				if (ch == '=') {
					break;
				}
				operando = "";
			} else if (ch != ' ') {
//				throw new Exception("Caracter no valido.");
			}
		}
		return 0;
	}
	private static void calculaRegEx(String expresion) {
		var pattern =Pattern.compile("\\s*([0-9,]+)\\s*([+-/*=])", Pattern.MULTILINE);
	    var matcher = pattern.matcher(expresion);
	    while(matcher.find()) {
	    	System.out.println(matcher.group(1) + " " + matcher.group(2));
	    }
	} 

}
