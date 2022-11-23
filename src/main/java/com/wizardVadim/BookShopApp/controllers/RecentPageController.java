package com.wizardVadim.BookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecentPageController {

    @GetMapping("/recent")
    public String getRecentPage() {
        return "books/recent";
    }
}
