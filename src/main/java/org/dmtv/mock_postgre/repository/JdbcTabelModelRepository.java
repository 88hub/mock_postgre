package org.dmtv.mock_postgre.repository;

import org.dmtv.mock_postgre.model.TabelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpStatusCodeException;


@Repository
public class JdbcTabelModelRepository implements TabelModelRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public TabelModel selectByLogin(String login) {
        try {
            TabelModel tb = jdbcTemplate.queryForObject("SELECT * FROM table1 JOIN table2 " +
                            "ON table1.login = table2.login WHERE table1.login=?",
                    BeanPropertyRowMapper.newInstance(TabelModel.class), login);
            return tb;
        }
        catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int insertTabelInfo(TabelModel tb) {
        return jdbcTemplate.update("WITH rows AS (INSERT INTO table1 (login, password, date) VALUES (?, ?, ?) RETURNING login) " +
                "INSERT INTO table2 (login, email) VALUES ((SELECT login FROM rows), ?)",
                new Object[] {tb.getLogin(), tb.getPassword(), tb.getDate(), tb.getEmail() });
    }
}
