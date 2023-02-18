package com.wizardVadim.BookShopApp.controllers;

import com.wizardVadim.BookShopApp.data.struct.book.Book;
import com.wizardVadim.BookShopApp.data.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class AccountController {

    private BookService bookService;

    @Autowired
    public AccountController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("postponedBooks")
    public List<Book> getPostponedBooks() {
        return this.bookService.getBooksForSection();
    }

    @ModelAttribute("cartBooks")
    public List<Book> getCartBooks() {
        return this.bookService.getBooksForSection();
    }

    @GetMapping("/postponed")
    public String getPostponedPage() {
        return "postponed";
    }

    @GetMapping("/cart")
    public String getCartPage() {
        return "cart";
    }
}
