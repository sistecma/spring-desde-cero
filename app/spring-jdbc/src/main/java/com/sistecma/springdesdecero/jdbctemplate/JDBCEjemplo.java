package com.sistecma.springdesdecero.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sistecma.springdesdecero.jdbctemplate.repositorio.RepositorioLogJDBCTemplate;

public class JDBCEjemplo {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext contexto = new AnnotationConfigApplicationContext(PersistenciaConfig.class);
		RepositorioLogJDBCTemplate repo= contexto.getBean(RepositorioLogJDBCTemplate.class);
		
		long id= repo.insertar("Esto es una prueba ...");
		String mensaje= repo.obtenerMensajePorId(id);
		
		System.out.println("Mensaje: " + mensaje);
	}

}
