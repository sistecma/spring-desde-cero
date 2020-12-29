package com.sistecma.springdesdecero.iocdi;

// inyeccion por metodos
public class Red{
	private ComputadoraDI computadora;
	private Servidor servidor;
    
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

	public ComputadoraDI getComputadora() {
		return computadora;
	}

	public void setComputadora(ComputadoraDI computadora) {
		this.computadora = computadora;
	}

	public Servidor getServidor() {
		return servidor;
	}

	public void setServidor(Servidor servidor) {
		this.servidor = servidor;
	}
}
