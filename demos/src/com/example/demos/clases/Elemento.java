package com.example.demos.clases;

public class Elemento<K, V> {
	private K codigo;
	private V literal;
	public Elemento(K codigo, V literal) {
		this.codigo = codigo;
		this.literal = literal;
	}
	public K getCodigo() {
		return codigo;
	}
	public void setCodigo(K codigo) {
		this.codigo = codigo;
	}
	public V getLiteral() {
		return literal;
	}
	public void setLiteral(V literal) {
		this.literal = literal;
	}
	
	
}
