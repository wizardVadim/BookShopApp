package com.wizardVadim.BookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {

    private JdbcTemplate jdbcTemplate;
    private AuthorService authorService;
    private static final int MIN_PERCENT = 1;
    private static final int MAX_PERCENT = 5;

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
        List<Book> bookData = getBooksData();
        for (Book book : bookData) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

}
