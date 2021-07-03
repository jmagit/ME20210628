package com.example.demos.clases;

import java.util.Date;

public class Factura {
	private static final int PLAZO_MAXIMO = 60;
	private int numFactura;
	private Date fecha;
	private Estado estado;
	Direccion emisor, receptor;
	Linea[] lineas;
	
	public enum Estado {
		PENDIENTE, PAGADA, CANCELADA, ANULADA, IMPAGADA
	}
	
	public static class Direccion {
		private String calle;
		
		public String getCalle() {
			int i = PLAZO_MAXIMO;
			return calle;
		}
	}
	public class Linea {
		int numLinea;
		int cantidad = 0;
		double precio = 0.0;
		// private int numFactura;
		
		public int getNumFactura() {
			return numFactura;
		}
		
	}
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public void visar(Validacion validador) {
		if(validador.esValido()) {
			
		}
	}
	
	public void kk() {
		int b = numFactura;
		class Valida implements Validacion {
			@Override
			public boolean esValido() {
				return numFactura > 1000;
			}
		}
		visar(new Valida());
	}
	public void k() {
		visar(() -> numFactura > 1000);
	}
	public void kkk() {
		visar(new Validacion() {
			@Override
			public boolean esValido() {
				return numFactura > 1000;
			}
		});
	}
}
