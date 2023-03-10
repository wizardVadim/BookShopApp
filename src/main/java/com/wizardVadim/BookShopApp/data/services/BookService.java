package com.wizardVadim.BookShopApp.data.services;

import com.wizardVadim.BookShopApp.data.repositories.BookRepository;
import com.wizardVadim.BookShopApp.data.services.AuthorService;
import com.wizardVadim.BookShopApp.data.struct.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class BookService {

    private BookRepository bookRepository;
    private AuthorService authorService;
    private static final int MIN_PERCENT = 1;
    private static final int MAX_PERCENT = 5;

    @Autowired
    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    public List<Book> getBooksData() {
        return bookRepository.findAll();
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
        return bookRepository.findById(id).get();
    }

    public List<Book> getBooksByAuthor(Integer id) {
        return bookRepository.findBooksByAuthorId(id);
    }

}
