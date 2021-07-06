package com.example.demos.clases;

import java.util.Date;
import java.util.Objects;

import com.example.demos.interfaces.Alimentarse;

public abstract class Persona implements Alimentarse, Comparable<Persona> {
	public static final String PREFIJO = "p";
	public final String soloLectura = "";

	private static int count = 0;
	static {
		count = 0;
		// ...
	}

	private int id;
	private String nombre;
	private String apellidos;
	private int edad;
	private Date fechaNacimiento;
	private boolean activa;
	private Date fechaBaja;

	private Persona() {
		this.activa = true;
		count++;
	}

	public Persona(int id, String nombre) {
		//this();
		this.id = id;
		this.nombre = nombre;
		//this.fechaNacimiento = new date()
	}
	public Persona(int id, String nombre, String apellidos) {
		//this();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		//this.fechaNacimiento = new date()
	}

//	public static Persona cuandoSoloNecesitasElNombre(int id, String nombre) {
//		return new Persona(id, nombre);
//	}
	public abstract void firma();
	
	public static int getCount() {
		return count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String valor) {
		if (nombre != null && nombre.equals(valor))
			return;
		nombre = valor;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
//		if(fechaNacimiento == null) {
//			// Error
//		}
//		return (new Date()).getYear() - fechaNacimiento.getYear();
		return edad;
	}

	public Date getFechaNacimiento() {
		return (Date) fechaNacimiento.clone();
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		this.edad = (new Date()).getYear() - fechaNacimiento.getYear();
	}

	public void jubilate() {
		activa = false;
		fechaBaja = new Date();
	}
	@Override
	protected void finalize() throws Throwable {
		count--;
		super.finalize();
	}
	@Override
	public void tomarCafe() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Persona))
			return false;
		return id == ((Persona) obj).id;
	}
	
	@Override
	public int compareTo(Persona o) {
		return id - o.id;
	}
}
