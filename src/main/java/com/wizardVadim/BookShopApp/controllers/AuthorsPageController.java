package com.wizardVadim.BookShopApp.controllers;

import com.wizardVadim.BookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookshop")
public class AuthorsPageController {

    private BookService bookService;

    @Autowired
    public AuthorsPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/authors")
    public String getAuthorsPage(Model model) {
        model.addAttribute("authorsData", bookService.getAuthorsData());
        return "authors/index";
    }
}
