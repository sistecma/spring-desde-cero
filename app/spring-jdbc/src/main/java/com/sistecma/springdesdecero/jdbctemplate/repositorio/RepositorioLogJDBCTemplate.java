package com.sistecma.springdesdecero.jdbctemplate.repositorio;

import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioLogJDBCTemplate {

    @Autowired
    JdbcTemplate jdbcTemplate;

    final String INSERT_SQL = "insert into log (mensaje) values(?) ";

    public long insertar(final String message) {
        
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(INSERT_SQL);
            ps.setString(1, message);
            return ps;
        }, keyHolder);

        return (long) keyHolder.getKey();
    }

    final String SELECT_SQL = "select mensaje from log where id = ?";

    public String obtenerMensajePorId(long id) {
        return jdbcTemplate.queryForObject(SELECT_SQL, String.class, new Object[] { id });
    }

}
