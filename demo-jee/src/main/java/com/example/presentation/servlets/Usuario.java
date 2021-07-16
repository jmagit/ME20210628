package com.example.presentation.servlets;

public class Usuario {
	private String nombre = "(anonimo)";
	private String contrase�a = "";
	private boolean autenticado = false;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getContrase�a() {
		return contrase�a;
	}
	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}
	public boolean isAutenticado() {
		return autenticado;
	}
	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}
	
	public void logout() {
		nombre = "(anonimo)";
		contrase�a = "";
		autenticado = false;
	}
}
