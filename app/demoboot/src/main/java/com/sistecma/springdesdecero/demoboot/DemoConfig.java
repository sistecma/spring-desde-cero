package com.sistecma.springdesdecero.demoboot;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

// La anotación @Configuration indica a Spring que la clase PersistenciaConfig permitirá la configuración de beans
// Osea este es el nuevo lugar donde usas la metadata para hacer el wiring de tus beans.
@Configuration
// @ComponentScan indica a Spring que escanee cualquier componente en dicho package/paquete java
//@ComponentScan("com.sistecma.springdesdecero.demoboot")
public class DemoConfig {
    
	// @Bean es la declaracion de un Spring Bean
	// En este caso el bean es de tipo DataSource y tiene como id dataSource (que es el nombre del método)
    @Bean
    public DataSource dataSource() {
    	// Construimos el bean
    	// En este caso como usamos H2 podemos usar el EmbeddedDatabaseBuilder
    	// y cargamos un script llamado esquema.sql que esta en el classpath
    	// y sirve para inicializar crear la tabla.
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql")
                .build();
    }

	// @Bean es la declaracion de un Spring Bean
	// En este caso el bean es de tipo JdbcTemplate y tiene como id jdbcTemplate (que es el nombre del método) y
    // recibe como parámetro un bean tipo DataSource
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
    	// Construimos el bean
        return new JdbcTemplate(dataSource);
    }
    
}
