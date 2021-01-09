package com.sistecma.springdesdecero.iocdi;

import org.springframework.context.ApplicationContext;

public class MiRunnable implements Runnable{
	
	private ApplicationContext ctx= null;
	private Contador contador= null;
	
	public MiRunnable(ApplicationContext ctx) {
	  this.ctx= ctx;	
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	    contador= ctx.getBean(MiThread.class);	
	}

	public Contador getContador() {
		return contador;
	}
}
