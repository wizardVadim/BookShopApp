package com.wizardVadim.BookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/documents")
public class DocumentController {

    @GetMapping()
    public String getDocumentsPage() {
        return "documents/index";
    }

    @GetMapping("/slug")
    public String getDocument() {
        return "documents/slug";
    }
}
