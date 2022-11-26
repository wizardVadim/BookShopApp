package com.wizardVadim.BookShopApp.controllers;

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

@Controller
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks() {
        return this.bookService.getBooksForSection();
    }
    @ModelAttribute("recentBooks")
    public List<Book> recentBooks() {
        return this.bookService.getBooksForSection();
    }

    @GetMapping("/slug")
    public String getBook(@RequestParam(value = "id") Integer id,
                          Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        return "books/slug";
    }

    @GetMapping("/popular")
    public String getPopularPage() {
        return "books/popular";
    }

    @GetMapping("/recent")
    public String getRecentPage() {
        return "books/recent";
    }


}
