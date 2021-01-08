package com.sistecma.springdesdecero.jdbctemplate;

// Usamos el paquete org.slf4j.Logger como libreria para tener diversos tipos de granularidad a nivel de log
/*
 * Hay categorias DEBUG, INFO, WARN, TRACE, ERROR
 * Agregamos este dependencia en el pom.xml para que maven la gestione
 *      <dependency>
		    <groupId>ch.qos.logback</groupId>
		    <artifactId>logback-classic</artifactId>
		    <version>1.1.7</version>
		</dependency>	
 * Asi mismo en el classpath agregamos el archivo de configuracion para el log
 * Ver logback.xml en el directorio src/main/resources		
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sistecma.springdesdecero.jdbctemplate.repositorio.RepositorioLogJDBCTemplate;

// Clase principal que ejecuta la lógica de negocio en método main
public class JDBCEjemplo {
    
	// Al usar el log en esta clase debes definirlo asi.
	// Donde LoggerFactory.getLogger(NOMBRE_DE_CLASE_DONDE_LO_USO.class);
	private static final Logger log= LoggerFactory.getLogger(JDBCEjemplo.class);
	  
	// En este caso la lógica de negocio solo es insertar un mensaje en la base de datos (H2) y luego leerlo
	// mostrando el mensaje en consola vía el log.info
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		// En este caso usamos AnnotationConfigApplicationContext para que el contenedor lea la configuracion
		// que esta presente en PersistenciaConfig
		ApplicationContext contexto = new AnnotationConfigApplicationContext(PersistenciaConfig.class);
		
		// Obtenemos el bean de tipo RepositorioLogJDBCTemplate
		RepositorioLogJDBCTemplate repo= contexto.getBean(RepositorioLogJDBCTemplate.class);
		
		// aplicamos un insert a la base y obtenemos el id
		long id= repo.insertartMensaje("Esto es una prueba ...");
		
		// obtenemos el mensaje consultando a la base x el id
		String mensaje= repo.obtenerMensajePorId(id);
		
		// mandamos al log el mensaje
		log.info("Mensaje: " + mensaje);
		
	}

}
