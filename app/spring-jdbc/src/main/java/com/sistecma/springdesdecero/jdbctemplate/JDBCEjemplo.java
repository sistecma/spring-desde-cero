package com.sistecma.springdesdecero.jdbctemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sistecma.springdesdecero.jdbctemplate.repositorio.RepositorioLogJDBCTemplate;

public class JDBCEjemplo {

	private static final Logger log= LoggerFactory.getLogger(JDBCEjemplo.class);
	  
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext contexto = new AnnotationConfigApplicationContext(PersistenciaConfig.class);
		RepositorioLogJDBCTemplate repo= contexto.getBean(RepositorioLogJDBCTemplate.class);
		
		long id= repo.insertartMensaje("Esto es una prueba ...");
		String mensaje= repo.obtenerMensajePorId(id);
		
		log.info("Mensaje: " + mensaje);
	}

}
