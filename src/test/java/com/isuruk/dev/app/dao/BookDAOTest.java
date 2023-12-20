package com.isuruk.dev.app.dao;

import com.isuruk.dev.app.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookDAOTest {

    @InjectMocks
    BookDAO underTest;

    @Mock
    JdbcTemplate jdbcTemplate;

    @Test
    void testThatCreateBookGenerateCorrectSQL(){

        Book book = Book.builder()
                .isbn("978-0590353427")
                .title("Harry Potter and the Sorcerer's Stone")
                .authorId(1)
                .build();

        underTest.create(book);
        verify(jdbcTemplate).update(
                eq("INSERT INTO book (isbn, title, author_id) VALUES (?,?,?)"),
                eq("978-0590353427"),
                eq("Harry Potter and the Sorcerer's Stone"),
                eq(1)
        );
    }
}
