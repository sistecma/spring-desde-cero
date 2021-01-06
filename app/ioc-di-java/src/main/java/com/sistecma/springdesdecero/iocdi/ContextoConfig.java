package com.sistecma.springdesdecero.iocdi;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// ContextoConfig.java sostiene todas las configuraciones asociadas con el proyecto.

// Anotación que indica que la clase ContextoConfig va a ser usada como configuración por el contenedor de Spring
@Configuration
// Anotación que permite leer la propiedad equipos.properties que esta ubicada en el classpath.
@PropertySource("classpath:equipos.properties")
public class ContextoConfig {
	
	// Anotación que indica que el siguiente método será usado para fabricar un bean tipo Monitor y 
	// con nombre igual al nombre del método(monitor)
	@Bean
	public Monitor monitor() {
		return new MonitorImpl();
	}

	// Anotación que indica que el siguiente método será usado para fabricar un bean tipo Equipo y 
	// con nombre igual al nombre del método(computadora)
	@Bean
	public Equipo computadora( 
			                  // El contenedor busca en el contexto un bean que implemente un bean tipo Monitor
			                  // El único es implementado x el método: monitor de esta misma clase ContextoConfig.java
							  /*
							   * @Bean
								 public Monitor monitor() {			
							  */
			                  Monitor monitor,
			                  // La anotación @Value("${computadora.ip}")
			                  // busca por el valor de la propiedad computadora.ip dentro del archivo equipos.properties
			                  @Value("${computadora.ip}") String ip, 
			                  // La anotación @Value("${computadora.hostname}")
			                  // busca por el valor de la propiedad computadora.hostname dentro del archivo equipos.properties
			                  @Value("${computadora.hostname}") String hostname) {
		return new ComputadoraDI(monitor,ip, hostname);
	}

	// Anotación que indica que el siguiente método será usado para fabricar un bean tipo Equipo y 
	// con nombre igual al nombre del método(servidor)
	@Bean
	public Equipo servidor(
					         // La anotación @Value("${servidor.ip}")
					         // busca por el valor de la propiedad servidor.ip dentro del archivo equipos.properties
			                 @Value("${servidor.ip}") String ip, 
					         // La anotación @Value("${servidor.hostname}")
					         // busca por el valor de la propiedad servidor.hostname dentro del archivo equipos.properties			                 
			                 @Value("${servidor.hostname}") String hostname) {
		Servidor servidor= new Servidor();
		servidor.setIp(ip);              // seteo de ip 
		servidor.setHostname(hostname);  // seteo de hostname
		return servidor;
	}
	
	@Bean
	public Red red(Equipo computadora, Equipo servidor) {
		Red red = new Red();
		red.setComputadora(computadora); // seteo de computadora
		red.setServidor(servidor);       // seteo de servidor
		return red;
	}

    // Realiza la ejecución del método init. Justo después de crear el bean	
    @PostConstruct
	public void init() {
    	System.out.println("ContextoConfig.init");
	}
    
    // Realiza la ejecución del método shutdown. Justo antes de eliminar el bean
    @PreDestroy
    public void destroy() {
    	System.out.println("ContextoConfig.destroy");
    }    
}
