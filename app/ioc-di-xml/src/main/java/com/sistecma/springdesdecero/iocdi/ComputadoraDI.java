package com.sistecma.springdesdecero.iocdi;

public class ComputadoraDI implements Equipo{
    private Monitor monitor;
    private String ip;
    private String hostname;
    
    // inyeccion por constructor
    public ComputadoraDI(Monitor monitor,String ip,String hostname) {
        this.monitor = monitor;
        this.ip= ip;
        this.hostname= hostname;
    }
    
    // invocado internamente por init-method="boot" en contexto-1.xml
    public void boot() {
    	System.out.println("equipo " + hostname + " esta " + monitor.mostrar("booteando..."));
    }
    
    // invocado internamente por destroy-method="shutdown" en contexto-1.xml
    public void shutdown() {
    	System.out.println("apagando equipo " + hostname);
    }
    
	@Override
	public String ping() {
		return ip;
	}

	@Override
	public String hostname() {
		
		return hostname;
	}
    
}
