package com.sistecma.springdesdecero.iocdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Red{
	private Equipo computadora;
	private Equipo servidor;

    // Realiza la ejecución del método configurar. Justo después de crear el bean
	@PostConstruct
	public void configurar() {
		System.out.println("red configurada...");
	}

    // Realiza la ejecución del método eliminar. Justo antes de eliminar el bean	
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
