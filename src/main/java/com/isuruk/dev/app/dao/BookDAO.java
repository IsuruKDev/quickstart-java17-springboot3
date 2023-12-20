package com.isuruk.dev.app.dao;

import com.isuruk.dev.app.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void create(Book book) {

        String sql = "INSERT INTO book (isbn, title, author_id) VALUES (?,?,?)";

        jdbcTemplate.update(sql, book.getIsbn(), book.getTitle(), book.getAuthorId());
    }

    public Optional<Book> findOne(String isbn) {

        String sql = "SELECT isbn, titile, author_id FROM book WHERE isbn = ?";

        List<Book> results = jdbcTemplate.query(sql, (rs, rowNum) -> {
            return Book.builder()
                    .isbn(rs.getString("isbn"))
                    .title(rs.getString("titile"))
                    .authorId(rs.getInt("author_id"))
                    .build();
        }, isbn);

        return results.stream().findFirst();
    }
}
