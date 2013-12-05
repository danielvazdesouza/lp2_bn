package com.senac.lista;

public abstract class Nodo {

	private Nodo prox;

	public void next(Nodo prox) {
		this.prox = prox;
	}

	public Nodo next() {
		return this.prox;
	}

	public abstract boolean compare(Object key);

}
