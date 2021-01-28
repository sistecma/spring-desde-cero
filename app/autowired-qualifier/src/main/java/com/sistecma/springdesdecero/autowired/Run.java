package com.sistecma.springdesdecero.autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Run {
	public static void main(String[] args) {
        ApplicationContext contexto= new AnnotationConfigApplicationContext(Run.class);
        PrintService servicio= (PrintService) contexto.getBean(PrintService.class);
        System.out.println(servicio.imprimeConPrinter());
    }
}
