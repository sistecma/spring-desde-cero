package com.sistecma.springdesdecero.demoboot;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ClienteRowMapper implements RowMapper<Cliente> {

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        Cliente cliente = new Cliente();

        cliente.setId(rs.getInt("id"));
        
        cliente.setNombres(rs.getString("nombres"));
        cliente.setApellidos(rs.getString("apellidos"));
        cliente.setCedula(rs.getString("cedula"));
        cliente.setCelular(rs.getString("celular"));
        cliente.setCorreo(rs.getString("correo"));      
        
        return cliente;
	}

}
