package com.wizardVadim.BookShopApp.data.services;

import com.wizardVadim.BookShopApp.data.repositories.AuthorRepository;
import com.wizardVadim.BookShopApp.data.struct.author.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Map<String, List<Author>> getAuthorsMap() {
        return getAuthorsData().stream().collect(Collectors.groupingBy((Author a) -> {return a.getName().substring(0, 1);}));
    }

    public List<Author> getAuthorsData() {
        return authorRepository.findAll();
    }

    public Author getAuthor(Integer authorId) {
        return authorRepository.findById(authorId).get();
    }
}
