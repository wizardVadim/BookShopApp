package com.wizardVadim.BookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Author getAuthor(Integer authorId) {
        return jdbcTemplate.query("SELECT * FROM authors WHERE id=?", new Object[]{authorId},
                new BeanPropertyRowMapper<>(Author.class)).stream().findAny().orElse(new Author("Unknown", "Unknown"));
    }

    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors ORDER BY last_name", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            author.setId(rs.getInt("id"));
            return author;
        });
        return authors.stream().collect(Collectors.groupingBy((Author a) -> {return a.getLastName().substring(0, 1);}));
    }
}
