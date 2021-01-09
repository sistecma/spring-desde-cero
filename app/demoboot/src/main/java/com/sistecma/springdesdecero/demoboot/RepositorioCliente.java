package com.sistecma.springdesdecero.demoboot;

import java.sql.Types;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCliente {
    
	@Autowired
    JdbcTemplate jdbcTemplate;

    final String INSERT_SQL = "insert into clientes (nombres,apellidos, cedula, celular, correo) values(?,?,?,?,?) ";
    final String SELECT_SQL = "select * from clientes where id = ?";
    

    public long agregarCliente(Cliente cliente) {

        PreparedStatementCreatorFactory fabrica =
                new PreparedStatementCreatorFactory(INSERT_SQL);
        
        fabrica.addParameter(new SqlParameter(Types.VARCHAR));
        fabrica.addParameter(new SqlParameter(Types.VARCHAR));
        fabrica.addParameter(new SqlParameter(Types.VARCHAR));
        fabrica.addParameter(new SqlParameter(Types.VARCHAR));
        fabrica.addParameter(new SqlParameter(Types.VARCHAR));
        
        fabrica.setReturnGeneratedKeys(true);
        fabrica.setGeneratedKeysColumnNames("id");
        
        PreparedStatementCreator CreadorDepreparedStatement= 
        		fabrica.newPreparedStatementCreator(new Object[]{cliente.getNombres(), cliente.getApellidos(), cliente.getCedula(), cliente.getCelular(), cliente.getCorreo()});

        KeyHolder llave = new GeneratedKeyHolder();
        jdbcTemplate.update(CreadorDepreparedStatement, llave);

        return (long) llave.getKey();
    }
    

	public Cliente obtenerClientePorId(long id) {
        return jdbcTemplate.queryForObject(SELECT_SQL,new ClienteRowMapper(),id);
    }
}
