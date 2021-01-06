package com.sistecma.springdesdecero.iocdi;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class JavaConfig {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext contexto = new AnnotationConfigApplicationContext(ContextoConfig.class);
		
		Equipo  computadora= (Equipo) contexto.getBean("computadora");
		System.out.println("equipo: " + computadora.hostname());
		
		Equipo  servidor= (Equipo) contexto.getBean("servidor");
		System.out.println("equipo: " + servidor.hostname());
		
		Red red= (Red) contexto.getBean("red");
		red.establecerPing();
        
		contexto.close();
	}

}
