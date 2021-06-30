package com.example;

import java.util.Date;

public class Persona {
	public static final String PREFIJO = "p";
	public final String soloLectura = "";
	
	private static int count = 0;
	
	private int id;
	private String nombre;
	private String apellido;
	private int edad;
	private Date fechaNacimiento;
	private boolean activa;
	private Date fechaBaja;
	
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
		if(nombre != null && nombre.equals(valor)) return;
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
		return (Date)fechaNacimiento.clone();
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		this.edad = (new Date()).getYear() - fechaNacimiento.getYear();
	}
	
	public void jubilate() {
		activa = false;
		fechaBaja = new Date();
	}
}
