package com.sistecma.springdesdecero.iocdi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:equipos.properties")
public class ContextoConfig {
	
	@Bean
	public Monitor monitor() {
		return new MonitorImpl();
	}

	@Bean
	public Equipo computadora( Monitor monitor, 
			                          @Value("${computadora.ip}") String ip, 
			                          @Value("${computadora.hostname}") String hostname) {
		return new ComputadoraDI(monitor,ip, hostname);
	}
	
	@Bean
	public Equipo servidor(@Value("${servidor.ip}") String ip, 
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
}
