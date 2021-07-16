package com.example.presentation.servlets;

public class Usuario {
	private String nombre = "(anonimo)";
	private String contraseña = "";
	private boolean autenticado = false;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public boolean isAutenticado() {
		return autenticado;
	}
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}
	
	public void logout() {
		nombre = "(anonimo)";
		contraseña = "";
		autenticado = false;
	}
}
