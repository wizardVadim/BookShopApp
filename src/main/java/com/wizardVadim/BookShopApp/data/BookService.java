package com.wizardVadim.BookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getBooksData() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum) -> {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setAuthor(getAuthor(book.getId()).getName());
                book.setTitle(rs.getString("title"));
                book.setPriceOld(rs.getString("price_old"));
                book.setPrice(rs.getString("price"));
                return book;
        });
        return new ArrayList<>(books);
    }

    public Author getAuthor(Integer authorId) {
        return jdbcTemplate.query("SELECT * FROM authors WHERE id=?", new Object[]{authorId},
                new BeanPropertyRowMapper<>(Author.class)).stream().findAny().orElse(new Author("Неизвестен"));
    }

    public List<Author> getAuthorsData() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors", (ResultSet rs, int rowNum) -> {
           Author author = new Author();
           author.setName(rs.getString("name"));
           author.setId(rs.getInt("id"));
           return author;
        });
        return new ArrayList<>(authors);
    }
}
