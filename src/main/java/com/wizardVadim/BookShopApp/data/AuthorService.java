package com.wizardVadim.BookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private NamedParameterJdbcTemplate jdbcTemplate;
    private final RowMapper<Author> ROW_MAPPER_AUTHORS = new RowMapper<Author>() {
        @Override
        public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
            Author author = new Author();
            author.setId(rs.getInt("id"));
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            return author;
        }
    };

    @Autowired
    public AuthorService(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Map<String, List<Author>> getAuthorsMap() {
        return getAuthorsData().stream().collect(Collectors.groupingBy((Author a) -> {return a.getLastName().substring(0, 1);}));
    }

    public List<Author> getAuthorsData() {
        List<Author> authors = jdbcTemplate.query("SELECT * FROM authors ORDER BY last_name", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setFirstName(rs.getString("first_name"));
            author.setLastName(rs.getString("last_name"));
            author.setId(rs.getInt("id"));
            return author;
        });
        return new ArrayList<>(authors);
    }

    public Author getAuthor(Integer authorId) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", authorId);
        return jdbcTemplate.queryForObject("SELECT * FROM authors WHERE id = :id", parameterSource, ROW_MAPPER_AUTHORS);
    }
}
