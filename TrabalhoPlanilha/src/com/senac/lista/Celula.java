package com.senac.lista;

public class Celula {

	String formula;
	double valor;
	String nome;
	
	public void setformula(String formula) {
		this.formula = formula;
	}
	
	public void setnome(String nome) {
		this.nome = nome;
	}
	
   public String getformula() {
		return formula;
	}
	public double getvalor() {
		return valor;
	}
	public String getnome() {
		return nome;
	}
	
	public boolean compare(Object key) {
		if(key instanceof String){
			return nome.equals(key);
		}
		return false;
	}
}
