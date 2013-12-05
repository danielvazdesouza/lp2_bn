package com.senac.lista;

public class Lista {

	private Nodo head;
	Celula celula = new Celula();

	public void insert(Nodo before, Nodo novo) {
		if (before == null) {
			novo.next(head);
			head = novo;

		} else {
			novo.next(before.next());
			before.next(novo);
		}
	}

	public void removeNext(Nodo before) {
		if (before != null) {
			Nodo prox = before.next().next();
			before.next(prox);

		} else {
			head = head.next();
		}
	}

	public Nodo search(Object key) {
		Nodo elem = head;

		while (elem != null) {
			if (elem.compare(key)) {
				return elem;
			} else {
				return elem;
			}
		}

		return null;
	}

}
