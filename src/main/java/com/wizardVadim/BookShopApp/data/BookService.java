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
    private AuthorService authorService;

    @Autowired
    public BookService(JdbcTemplate jdbcTemplate, AuthorService authorService) {
        this.jdbcTemplate = jdbcTemplate;
        this.authorService = authorService;
    }

    public List<Book> getBooksData() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", (ResultSet rs, int rowNum) -> {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setAuthor(authorService.getAuthor(book.getId()).getFullName());
                book.setTitle(rs.getString("title"));
                book.setPriceOld(rs.getString("price_old"));
                book.setPrice(rs.getString("price"));
                return book;
        });
        return new ArrayList<>(books);
    }
}
