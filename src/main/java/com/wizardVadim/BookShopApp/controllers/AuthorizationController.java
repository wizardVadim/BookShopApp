package com.wizardVadim.BookShopApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorizationController {

    @GetMapping("/signin")
    public String getSignInPage() {
        return "signin";
    }

    @GetMapping("/signup")
    public String getSignUpPage() {
        return "signup";
    }
}
