package com.sistecma.springdesdecero.iocdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.AbstractApplicationContext;

public class JavaConfig {

	public static void main(String[] args) {

		// Puedes usar AbstractApplicationContext cuando uses @PostContruct y @PreDestroy 
		AbstractApplicationContext contexto = new AnnotationConfigApplicationContext(ContextoConfig.class);
		
		// cuando se ejecuta la linea: contexto.getBean("computadora")
		// busca en el contenedor por un bean con nombre "computadora"
		// el contenedor resuelve que esta en: Clase ContextoConfig.java
		/*  
		 * 	@Bean
	        public Equipo computadora( Monitor monitor, 
		 */
		// Donde el nombre del método computadora en ContextoConfig.java corresponde al nombre del bean.
		Equipo  computadora= (Equipo) contexto.getBean("computadora");
		System.out.println("equipo: " + computadora.hostname());
		
		// cuando se ejecuta la linea: contexto.getBean("servidor")
		// busca en el contenedor por un bean con nombre "servidor"
		// el contenedor resuelve que esta en: Clase ContextoConfig.java
		/*  
		 * 	@Bean
	        public Equipo servidor( 
		 */
		// Donde el nombre del método servidor en ContextoConfig.java corresponde al nombre del bean.
		Equipo  servidor= (Equipo) contexto.getBean("servidor");
		System.out.println("equipo: " + servidor.hostname());

		// cuando se ejecuta la linea: contexto.getBean("red")
		// busca en el contenedor por un bean con nombre "red"
		// el contenedor resuelve que esta en: Clase ContextoConfig.java
		/*  
		 * 	@Bean
	        public Equipo red( 
		 */
		// Donde el nombre del método servidor en ContextoConfig.java corresponde al nombre del bean.
		Red red= (Red) contexto.getBean("red");
		red.establecerPing();
        
		contexto.close();
	}

}
