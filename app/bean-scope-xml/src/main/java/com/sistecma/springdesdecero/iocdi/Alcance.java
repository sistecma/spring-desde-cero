package com.sistecma.springdesdecero.iocdi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Alcance {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		// Singleton
		Contador singleton1 = ctx.getBean(Singleton.class);
		System.out.println("contador.singleton-1.original: " + singleton1.getContador());
		System.out.println("contador.singleton-1.incrementar: " + singleton1.incrementarContador());

		Contador singleton2 = ctx.getBean(Singleton.class);
		System.out.println("contador.singleton-2.original: " + singleton2.getContador());
		System.out.println("contador.singleton-2.incrementar: " + singleton2.incrementarContador());
		
		System.out.println("");
		
		// Prototipo
		Contador prototipo1= ctx.getBean(Prototipo.class);
		System.out.println("contador.prototipo-1.original: " + prototipo1.getContador());
		System.out.println("contador.prototipo-1.incrementar: " + prototipo1.incrementarContador());	

		Contador prototipo2= ctx.getBean(Prototipo.class);
		System.out.println("contador.prototipo-2.original: " + prototipo2.getContador());
		System.out.println("contador.prototipo-2.incrementar: " + prototipo2.incrementarContador());	
		
		System.out.println("");
		
		// Invocando desde el mismo Thread (su comportamiento debería ser como singleton)
		Contador thread1= ctx.getBean(MiThread.class);
		System.out.println("contador.thread1.original: " + thread1.getContador());
		System.out.println("contador.thread1.incrementar: " + thread1.incrementarContador());		

		Contador thread2= ctx.getBean(MiThread.class);
		System.out.println("contador.thread2.original: " + thread2.getContador());
		System.out.println("contador.thread2.incrementar: " + thread2.incrementarContador());
		
		// Invocando desde diferentes Threads (su comportamiento debería ser como prototipo)
		MiRunnable r1 = new MiRunnable(ctx);
		MiRunnable r2 = new MiRunnable(ctx);
		
		Thread t1 = new Thread(r1);
	    Thread t2 = new Thread(r2);
	    
	    // iniciamos
	    t1.start();
	    t2.start();
	    
	    // esperamos para asegurarnos de que ambos threads estén listos
	    t1.join();
	    t2.join();
	    
	    Contador thread3= r1.getContador();
		System.out.println("contador.thread3.original: " + thread3.getContador());	   
		System.out.println("contador.thread3.incrementar: " + thread3.incrementarContador());	
		
	    Contador thread4= r2.getContador();
		System.out.println("contador.thread4.original: " + thread4.getContador());	   
		System.out.println("contador.thread4.incrementar: " + thread4.incrementarContador());		
	}

}
