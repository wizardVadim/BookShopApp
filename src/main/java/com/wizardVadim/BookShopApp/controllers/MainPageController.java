package com.wizardVadim.BookShopApp.controllers;

import com.wizardVadim.BookShopApp.data.struct.book.Book;
import com.wizardVadim.BookShopApp.data.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks() {
        return this.bookService.getBooksForSection();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks() {
        return this.bookService.getBooksForSection();
    }

    @ModelAttribute("recentBooks")
    public List<Book> recentBooks() {
        return this.bookService.getBooksForSection();
    }

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/about")
    public String getAboutPage() {
        return "about";
    }

    @GetMapping("/faq")
    public String getFaqPage() {
        return "faq";
    }

    @GetMapping("/contacts")
    public String getContactsPage() {
        return "contacts";
    }


}
