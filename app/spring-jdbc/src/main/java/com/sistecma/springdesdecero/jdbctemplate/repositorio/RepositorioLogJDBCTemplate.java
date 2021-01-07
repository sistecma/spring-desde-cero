package com.sistecma.springdesdecero.jdbctemplate.repositorio;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioLogJDBCTemplate {

    @Autowired
    JdbcTemplate jdbcTemplate;

    final String INSERT_SQL = "insert into log (mensaje) values(?) ";
    final String SELECT_SQL = "select mensaje from log where id = ?";
    

    public long insertartMensaje(String mensaje) {

        PreparedStatementCreatorFactory fabrica =
                new PreparedStatementCreatorFactory(INSERT_SQL,Types.VARCHAR);
        
        fabrica.setReturnGeneratedKeys(true);
        fabrica.setGeneratedKeysColumnNames("id");
        
        PreparedStatementCreator CreadorDepreparedStatement= 
        		fabrica.newPreparedStatementCreator(new Object[]{mensaje});

        KeyHolder llave = new GeneratedKeyHolder();
        jdbcTemplate.update(CreadorDepreparedStatement, llave);

        return (long) llave.getKey();
    }
    
    public String obtenerMensajePorId(long id) {
        return jdbcTemplate.queryForObject(SELECT_SQL, String.class, new Object[] {id});
    }

}
