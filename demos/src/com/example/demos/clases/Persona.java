package com.example.demos.clases;

import java.util.Date;

import com.example.demos.interfaces.Alimentarse;

public abstract class Persona implements Alimentarse {
	public static final String PREFIJO = "p";
	public final String soloLectura = "";

	private static int count = 0;
	static {
		count = 0;
		// ...
	}

	private int id;
	private String nombre;
	private String apellido;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
}
