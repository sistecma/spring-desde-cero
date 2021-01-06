package com.sistecma.springdesdecero.iocdi;

import org.springframework.context.support.AbstractApplicationContext; 
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfig {
	public static void main(String[] args) {
		
		// Puedes usar AbstractApplicationContext cuando uses init-method y destroy-method en el xml de configuracion
		// puedes usar uno o varios archivos de configuracion en xml (cuando uses ClassPathXmlApplicationContext) 
		// igual todo es mapeado a un contexto global (incluso un xml puede importar las definiciones de otro xml ver dentro de contexto-1.xml)
		// por ejemplo:
		// revisar la definicion del bean Red en el contexto-2.xml hace referencia a sus dependencias
		// computadoraRef y servidorRef que fueron definidos en el archivo contexto-1.xml
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("contexto-1.xml","contexto-2.xml");
		
		// para este caso obtienes el bean de la clase ComputadoraDI.class 
		// pero lo asignas a su interfaz o contrato Equipo (por lo tanto a nivel del metodo estatico XmlConfig.main
		// solo podras usarlo con los metodos disponibles por la interfaz
		// sin embargo internamente Spring sostiene una referencia a la clase en si por esto puede aplicar los metodos
		// mapeados en ComputadoraDI como tal es el caso de boot y shutdown definidos dentro del bean del contexto-1.xml
		Equipo computadora = ctx.getBean(ComputadoraDI.class);
		System.out.println("equipo: " + computadora.hostname());
		
		Equipo servidor = ctx.getBean(Servidor.class);
		System.out.println("equipo: " + servidor.hostname());
		
		// para este caso el bean de la clase Red.class es asignado al mismo tipo Red.
		Red red = ctx.getBean(Red.class);
        red.establecerPing();
        
     // cierra el contexto, para cuando uses el AbstractApplicationContext y quieras que se ejecute destroy-method
		ctx.close(); 
	}
}