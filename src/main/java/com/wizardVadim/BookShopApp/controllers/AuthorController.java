package com.wizardVadim.BookShopApp.controllers;

import com.wizardVadim.BookShopApp.data.Author;
import com.wizardVadim.BookShopApp.data.AuthorService;
import com.wizardVadim.BookShopApp.data.Book;
import com.wizardVadim.BookShopApp.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @ModelAttribute("authorsMap")
    public Map<String, List<Author>> authorsMap() {
        Map<String, List<Author>> authorsMap = authorService.getAuthorsMap();
        return authorsMap;
    }

    @GetMapping()
    public String getAuthorsPage() {
        return "authors/index";
    }

    @GetMapping("/slug")
    public String getAuthor(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("author", authorService.getAuthor(id));
        model.addAttribute("books", bookService.getBooksByAuthor(authorService.getAuthor(id)));
        return "authors/slug";
    }
}
