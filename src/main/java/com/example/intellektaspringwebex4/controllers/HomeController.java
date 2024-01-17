package com.example.intellektaspringwebex4.controllers;

import com.example.intellektaspringwebex4.services.LoginProcessor;
import com.example.intellektaspringwebex4.services.SellerManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    private final SellerManagementService sellerManagementService;

    private final LoginProcessor loginProcessor;

    public HomeController(SellerManagementService sellerManagementService, LoginProcessor loginProcessor) {
        this.sellerManagementService = sellerManagementService;
        this.loginProcessor = loginProcessor;
    }

    @GetMapping("/")
    public String loginGet() {
        return "home.html";
    }

    @PostMapping("/")
    public String logging(@RequestParam String sellerName, Model model) {
        boolean loggedIn = loginProcessor.login();
        String message = "Welcome" + sellerName;
        sellerManagementService.setSellerName(sellerName);
        if (loggedIn) return "redirect:/working";
        else model.addAttribute("message", message);
        return "home.html";
    }
}
