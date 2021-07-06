package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.example.demos.clases.Alumno;
import com.example.demos.clases.Circulo;
import com.example.demos.clases.Elemento;
import com.example.demos.clases.ElementoCadena;
import com.example.demos.clases.Factura;
import com.example.demos.clases.Figura;
import com.example.demos.clases.Listado;
import com.example.demos.clases.Persona;
import com.example.demos.clases.Profesor;
import com.example.demos.interfaces.Grafico;
import com.example.demos.interfaces.Servicio;
import com.example.juegos.JuegoException;
import com.example.juegos.JuegoNumeros;
import com.example.juegos.ajedrez.Movimiento;
import com.example.juegos.ajedrez.Posicion;

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
		// juega();
		// calcula("3+4+3,4-7*1=");
		// calculaRegEx("3+4+3,4-7*1=");
		// ejemplos3();
//		ajedrez();
//		clasesInternas();
//		genericos();
		
		flujos();
	}
	
	public static void flujos() {
		List<Persona> lst = new ArrayList<>();
		lst.add(new Profesor(2, "Otro", "Profesor"));
		lst.add(new Profesor(1, "Pepito", "Grillo"));
		lst.add(new Alumno(1, "Pepito", "Grillo", 5));
		lst.add(new Alumno(3, "Carmelo", "Coton", 7));
		lst.add(new Alumno(4, "Pedro", "Pica Piedra", 2));
		lst.add(new Alumno(5, "Pablo", "Marmol", 6));
		lst.add(new Alumno(9, "Impar", "Marmol", 6));
		
//		lst.stream().filter(item -> item instanceof Profesor)
//			.map(item -> (Profesor)item)
//			//.sorted((a, b) -> b.getId() - a.getId())
//			.sorted((a, b) -> -a.getApellidos().compareToIgnoreCase(b.getApellidos()))
//			//.forEach(item -> System.out.println(item));
//			.forEach(System.out::println);
//		System.out.println(lst.stream()
//				.filter(item -> item instanceof Alumno)
//				.map(item -> ((Alumno)item).getNota())
//				.reduce(0, (a, item) -> a + item));
//		System.out.println(lst.stream()
//				.filter(item -> item instanceof Alumno)
//				.map(item -> ((Alumno)item))
//				.peek(item -> item.setNota((int)(item.getNota()*1.2)))
//				.mapToInt(item -> item.getNota())
//				.sum());
		int page=0, rows=3;
//		for(; page < 3; page++) {
//			System.out.println("Página "+(page+1)+":");
//			lst.stream()
//				//.sorted()
//				.sorted((a, b) -> -a.getApellidos().compareToIgnoreCase(b.getApellidos()))
//				.skip(page * rows)
//				.limit(rows)
//				.forEach(System.out::println);
//		}
		
//		List<Alumno> lstAlumnos = lst.stream()
//				.filter(item -> item instanceof Alumno)
//				.map(item -> ((Alumno)item))
//				.collect(Collectors.toList());
//		lstAlumnos.forEach(System.out::println);
//		System.out.println(lst.stream()
//				.filter(item -> item instanceof Alumno)
//				.map(item -> ((Alumno)item))
//				.peek(item -> item.setNota((int)(item.getNota()*1.2)))
//				.mapToInt(item -> item.getNota())
//				.sum());
//		lstAlumnos.forEach(System.out::println);
		
//		boolean paginado = true, soloAlumnos = true;
//		String prefijo = "Pe";
//		
//		var consulta = lst.stream();
//		if(soloAlumnos) {
//			consulta = consulta.filter(item -> item instanceof Alumno);
//		}
//		if(prefijo != null && !prefijo.isBlank()) {
//			consulta = consulta.filter(item -> item.getNombre().startsWith(prefijo));
//		}
//		if(paginado) {
//			consulta = consulta.sorted((a, b) -> -a.getApellidos().compareToIgnoreCase(b.getApellidos()))
//					.skip(page * rows)
//					.limit(rows);		
//		}
//		consulta.forEach(System.out::println);
//		consulta.forEach(System.out::println);
		
//		var rslt = lst.stream().filter(a -> a instanceof Alumno && a.getId() == 11).findFirst();
//		if(rslt.isEmpty()) {
//			System.out.println("No encontrado");
//		} else {
//			System.out.println(rslt.get());
//		}
		
		List<Integer> listOfIntegers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
		System.out.println("Sequential Stream: ");
		listOfIntegers.stream().map(v -> v*1.5).sorted().forEach(e -> System.out.print(e + " "));
		System.out.println("\nParallel Stream: ");
		listOfIntegers.stream().parallel().map(v -> v*1.5).sequential().sorted().forEach(e -> System.out.print(e + " "));

	}
	
	public static void cadenas() {
		String x = "";
//		for(int i=0; i < 10000; i++) {
//			System.out.print(x.length());
//			x+= "X";
//			System.out.println("->" + x.length());
//		}
		StringBuilder sb = new StringBuilder("");
		for(int i=0; i < 10000; i++) 
			sb.append("X");
		x = sb.toString();
		System.out.println("->" + x.length());
		
		Profesor p = new Profesor(1, "Pepito", "Grillo");
		Alumno a = new Alumno(1, "Pepito", "Grillo", 1);
		if(a.equals(p) && p.equals(a) && a.hashCode() == p.hashCode() && a.compareTo(p) == 0) {
			
		}
	
	}
	public static void anotaciones() {
		var anotaciones = JuegoException.class.getAnnotations();
		System.out.println(Profesor.class.getAnnotation(Autor.class).nombre());
	}
	@SuppressWarnings("unused")
	public static void genericos() {
		Listado<Alumno> alumListado = new Listado<Alumno>(new Alumno[10]);
		var profes = new Listado<Profesor>(new Profesor[3]);
		ElementoCadena<Integer> provincia = new ElementoCadena<Integer>(8, "Barcelona");
		Elemento<Character, String> genero = new Elemento<>('m', "Mujer");
		//Alumno a = profes.getPrimero();
		
		Object object = 5; // new Integer(5);
		int i = (int)object;  // object.get();
		i = provincia.getCodigo();
		Integer j = 5;
		i += j;
		if(object instanceof Integer) {
		}
	}
	
	public static void lamda() {
		String[] cadenas = {"uno", "dos", "tres" };
		//String[] cadenas2 = cadenas;
		try {
			System.out.println(busca(cadenas, s -> s.startsWith("u")));
			System.out.println(busca(cadenas, s -> s.startsWith("t") && s.endsWith("s")));
			System.out.println(busca(cadenas, new Busca() {				
				@Override
				public boolean compara(String cadena) {
					return cadena.equals("tres");
				}
			}));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FunctionalInterface
	static interface Busca {
		boolean compara(String cadena);
	}
	
	@Deprecated
	public static String busca(String[] lista, Busca comp ) throws Exception {
		for(var item: lista) {
			if(comp.compara(item))
				return item;
		}
		throw new Exception();
	}

 	public static void clasesInternas() {
		Factura f = new Factura();
		Factura.Direccion direccion = new Factura.Direccion();
		if(f.getEstado() == Factura.Estado.PAGADA) {
			
		}
		//f.setEstado("PAGADA");
	}
	public static void ajedrez() {
		Posicion posicion;
		Movimiento m;
		try {
			posicion = new Posicion(1, 1);
			System.out.println(posicion);
			posicion = new Posicion('1', 'A');
			System.out.println(posicion);
			//posicion = new Posicion(0, 0);
			m = new Movimiento("A7B7");
			System.out.println(m);
			System.out.println(m.esVertical() ? "esVertical":"");
			System.out.println(m.esDiagonal() ? "esDiagonal":"");
			System.out.println(m.esHorizontal() ? "esHorizontal":"");
			System.out.println(m.saltoHorizontal());
		} catch (JuegoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void ejemplos3() {
		// Persona p = new Persona(1, "Pepito");
	}

	public static void ejemplos2() {
		Genero genero = Genero.DESCONOCIDO;
		if (genero == Genero.FEMENINO) {

		}

		Principal principal = new Principal();
		int i = 1, j = 2;
		principal.suma((double) i, j);
//		principal.suma();
//		principal.suma(1);
		double rslt = principal.suma("2", "2") + principal.suma(1, 2, principal.suma((double) i, j), 4, 5) * 4;
		Persona p = new Alumno();
		if (p instanceof Alumno)
			((Alumno) p).suspende();
		p.getFechaNacimiento().setYear(2030);
		Grafico a = null;
		a = new Figura();
		a = new Alumno();
		a.pintate();
		Object object = new Profesor(1, "Profe", "uno");
		if (object instanceof Grafico) {
			((Grafico) object).pintate();
		}
		// p.nombre="kk";
		Servicio srv = new Circulo();
	}

	public double suma(double a, double b, double... lst) {
		double rslt = a + b;
		for (double valor : lst) {
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

	public static void juegaConClase() {
		JuegoNumeros j = new JuegoNumeros();
		do {
			j.inicializa();
			// System.out.print("El número: " + numeroBuscado);
			do {
				try {
					System.out.print("Dame tu número (" + (j.getIntentos() + 1) + " de 10): ");
					System.out.println(j.juega(Integer.parseInt(leer())));
				} catch (JuegoException ex) {
					System.out.println(ex.getMessage());
				} catch (NumberFormatException ex) {
					System.out.println("No es un número valido.");
					// throw new JuegoException("mal el numero", ex);
				}
			} while (j.deboSeguir());

			if (j.heGanado()) {
				System.out.println("Bieeen!!! Acertaste.");
			} else {
				System.out.println("Upsss! Se acabaron los intentos, el número era el " + j.getNumeroBuscado());
			}
			System.out.println("¿Otra? [S/N]");
		} while ("s".compareToIgnoreCase(leer()) == 0);
	}

	public static void juega() {
		do {
			var rnd = new Random();
			int numeroBuscado = rnd.nextInt(100);
			int numeroIntroducido;
			int intentos = 0;
			boolean encontrado = false;
			// System.out.print("El número: " + numeroBuscado);
			do {
				try {
					System.out.print("Dame tu número (" + (intentos + 1) + " de 10): ");
					numeroIntroducido = Integer.parseInt(leer());
					intentos += 1;
					if (numeroBuscado == numeroIntroducido) {
						encontrado = true;
					} else if (numeroBuscado > numeroIntroducido) {
						System.out.println("Mi número es mayor.");
					} else {
						System.out.println("Mi número es menor.");
					}
				} catch (Exception ex) {
					// System.out.println("No es un número valido.");
				}
			} while (intentos < 10 && !encontrado);

			if (encontrado) {
				System.out.println("Bieeen!!! Acertaste.");
			} else {
				System.out.println("Upsss! Se acabaron los intentos, el número era el " + numeroBuscado);
			}
			System.out.println("¿Otra? [S/N]");
		} while ("s".compareToIgnoreCase(leer()) == 0);
	}

	public static double calcula(String expresion) {
		String operando = "";

		// "([0-9,]+)|([+-/*=])"
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
		var pattern = Pattern.compile("\\s*([0-9,]+)\\s*([+-/*=])", Pattern.MULTILINE);
		var matcher = pattern.matcher(expresion);
		while (matcher.find()) {
			System.out.println(matcher.group(1) + " " + matcher.group(2));
		}
	}

}
