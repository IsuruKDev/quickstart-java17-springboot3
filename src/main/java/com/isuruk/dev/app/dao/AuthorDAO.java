package com.isuruk.dev.app.dao;

import com.isuruk.dev.app.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Author author) {

        String sql = "INSERT INTO author (id, name, age) VALUES (?,?,?)";

        jdbcTemplate.update(sql, author.getId(), author.getName(), author.getAge());

    }

    public Optional<Author> findOne(int authorId) {

        String sql = "SELECT id, name, age FROM author WHERE id = ? LIMIT 1";

        List<Author> results = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return Author.builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .age(rs.getInt("age"))
                    .build();
        }, authorId);

        return results.stream().findFirst();
    }
}
