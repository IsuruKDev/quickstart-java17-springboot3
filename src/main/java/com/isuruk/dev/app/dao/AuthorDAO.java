package com.isuruk.dev.app.dao;

import com.isuruk.dev.app.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Author author) {

        String sql = "INSERT INTO author (id, name, age) VALUES (?,?,?)";

        jdbcTemplate.update(sql, author.getId(), author.getName(), author.getAge());

    }
}
