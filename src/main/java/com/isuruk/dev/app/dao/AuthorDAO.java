package com.isuruk.dev.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AuthorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
}