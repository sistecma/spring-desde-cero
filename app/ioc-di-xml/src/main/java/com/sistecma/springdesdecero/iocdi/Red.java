package com.sistecma.springdesdecero.iocdi;

// inyeccion por metodos
public class Red{
	private Equipo computadora;
	private Equipo servidor;
    
	// invocado por init-method
	public void configurar() {
		System.out.println("red configurada...");
	}
	// invocado por destroy-method
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
