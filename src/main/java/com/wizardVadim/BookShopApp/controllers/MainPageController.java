package com.wizardVadim.BookShopApp.controllers;

import com.wizardVadim.BookShopApp.data.Book;
import com.wizardVadim.BookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String mainPage(Model model) {
        return "index";
    }

}
