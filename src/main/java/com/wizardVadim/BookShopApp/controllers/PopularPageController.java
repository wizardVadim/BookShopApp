package com.wizardVadim.BookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PopularPageController {

    @GetMapping("/popular")
    public String getPopularPage() {
        return "books/popular";
    }
}
