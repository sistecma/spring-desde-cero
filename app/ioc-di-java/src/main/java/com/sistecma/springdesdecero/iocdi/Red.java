package com.sistecma.springdesdecero.iocdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// inyeccion por métodos
public class Red{
	private Equipo computadora;
	private Equipo servidor;
    
	@PostConstruct
	public void configurar() {
		System.out.println("red configurada...");
	}
	
	@PreDestroy
	public void eliminar() {
		System.out.println("red eliminada...");
	}
	
    public void establecerPing(){
        System.out.println("Red. Recibido de: " + getComputadora().ping());
        System.out.println("Red. Recibido de: " + getServidor().ping());
    }

	public Equipo getComputadora() {
		return computadora;
	}

	public void setComputadora(Equipo computadora) {
		this.computadora = computadora;
	}

	public Equipo getServidor() {
		return servidor;
	}

	public void setServidor(Equipo servidor) {
		this.servidor = servidor;
	}
}
