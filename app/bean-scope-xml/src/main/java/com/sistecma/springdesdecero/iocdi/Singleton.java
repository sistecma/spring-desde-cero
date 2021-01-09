package com.sistecma.springdesdecero.iocdi;

public class Singleton implements Contador {
    private int contador= 0;

	public int getContador() {
		return contador;
	}

	public void setContador(int contador) {
		this.contador = contador;
	}

	@Override
	public int incrementarContador() {
		// TODO Auto-generated method stub
		contador= contador + 1;
		return contador;
	}

        
}
