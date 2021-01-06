package com.sistecma.springdesdecero.iocdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

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
    
    @PostConstruct
    public void boot() {
    	System.out.println("equipo " + hostname + " esta " + monitor.mostrar("booteando..."));
    }
    
    @PreDestroy
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
