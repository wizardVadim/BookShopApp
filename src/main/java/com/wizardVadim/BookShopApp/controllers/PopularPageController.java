package com.wizardVadim.BookShopApp.controllers;

import com.wizardVadim.BookShopApp.data.Book;
import com.wizardVadim.BookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class PopularPageController {

    BookService bookService;

    @Autowired
    public PopularPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks() {
        return this.bookService.getBooksForSection();
    }

    @GetMapping("/popular")
    public String getPopularPage() {
        return "books/popular";
    }
}
