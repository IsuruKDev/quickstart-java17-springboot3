package com.isuruk.dev.app.dao;

import com.isuruk.dev.app.model.Author;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthorDAOTest {

    @InjectMocks
    AuthorDAO underTest;

    @Mock
    JdbcTemplate jdbcTemplate;

    @Test
    void testThatCreateAuthorGenerateCorrectSQL(){
        Author author = Author.builder()
                .id(1)
                .name("Abi Mona")
                .age(25)
                .build();

        underTest.create(author);

        verify(jdbcTemplate).update(
                eq("INSERT INTO author (id, name, age) VALUES (?,?,?)"),
                eq(1),
                eq("Abi Mona"),
                eq(25)
        );
    }
}
