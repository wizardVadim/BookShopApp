package com.wizardVadim.BookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private AuthorService authorService;
    private static final int MIN_PERCENT = 1;
    private static final int MAX_PERCENT = 5;

    @Autowired
    public BookService(NamedParameterJdbcTemplate jdbcTemplate, AuthorService authorService) {
        this.jdbcTemplate = jdbcTemplate;
        this.authorService = authorService;
    }
    private final RowMapper<Book> ROW_MAPPER_BOOKS = new RowMapper<Book>() {
        @Override
        public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(authorService.getAuthor(book.getId()).getFullName());
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("price_old"));
            book.setPrice(rs.getString("price"));
            book.setAuthorId(rs.getInt("author_id"));
            return book;
        }
    };

    public List<Book> getBooksData() {
        List<Book> books = jdbcTemplate.query("SELECT * FROM books", ROW_MAPPER_BOOKS);
        return new ArrayList<>(books);
    }

    public List<Book> getBooksForSection() {
        List<Book> bookData = getBooksData();
        List<Book> booksForSection = new ArrayList<>();
        Random randomizer = new Random();


        for (int i = 0; i < bookData.size() / 100 * (MIN_PERCENT + randomizer.nextInt(MAX_PERCENT - MIN_PERCENT)); i++) {
            booksForSection.add(bookData.get(randomizer.nextInt(bookData.size())));
        }

        return booksForSection;
    }

    public Book getBookById(Integer id) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return jdbcTemplate.queryForObject("SELECT * FROM books WHERE id = :id", parameterSource, ROW_MAPPER_BOOKS);
    }

    public List<Book> getBooksByAuthor(Author author) {
        int id = author.getId();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);
        return jdbcTemplate.query("SELECT * FROM books WHERE author_id = :id ", parameterSource, ROW_MAPPER_BOOKS);
    }

}
