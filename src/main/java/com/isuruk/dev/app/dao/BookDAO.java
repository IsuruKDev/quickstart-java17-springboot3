package com.isuruk.dev.app.dao;

import com.isuruk.dev.app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void create(Book book) {

        String sql = "INSERT INTO book (isbn, title, author_id) VALUES (?,?,?)";

        jdbcTemplate.update(sql, book.getIsbn(), book.getTitle(), book.getAuthorId());
    }
}
