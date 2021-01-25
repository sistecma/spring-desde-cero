package com.sistecma.springdesdecero.iocdi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		// Puedes usar AbstractApplicationContext cuando uses init-method y destroy-method en el xml de configuracion
		// puedes usar uno o varios archivos de configuracion en xml (cuando uses ClassPathXmlApplicationContext) 
		// a partir de la siguiente linea observaras (en consola) que Spring comienza a invocar las implemetaciones de 
		// los metodos asociados a las interfaces del ciclo de vida de logs beans.
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("contexto.xml");
		
		// para este caso obtienes el bean de la clase MiBean.class
		MiBean bean = ctx.getBean(MiBean.class);
		
		// solo para comprobar que es un bean regular con logica regular. Invocamos su metodo logicaNegocio		
		System.out.println("bean.logicaNegocio: " + bean.logicaNegocio());
		
     // cierra el contexto, para cuando uses el AbstractApplicationContext y quieras que se ejecute destroy-method
		ctx.close(); 
	}
}
