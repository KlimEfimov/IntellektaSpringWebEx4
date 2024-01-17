package com.example.intellektaspringwebex4.controllers;

import com.example.intellektaspringwebex4.models.Sale;
import com.example.intellektaspringwebex4.repositories.SalesRepository;
import com.example.intellektaspringwebex4.services.SellerManagementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

@Controller
public class WorkingController {

    private final SellerManagementService sellerManagementService;
    private final SalesRepository salesRepository;

    public WorkingController(SellerManagementService sellerManagementService, SalesRepository salesRepository) {
        this.sellerManagementService = sellerManagementService;
        this.salesRepository = salesRepository;
    }

    @GetMapping("/working")
    public String working(Model model) {
        model.addAttribute("sellerName", sellerManagementService.getSellerName());
        model.addAttribute("sales", salesRepository.findAllSales());
//        System.out.println(sellerManagementService.getSellerName());
        return "working.html";
    }

    @PostMapping("/working")
    public String addSale(
            @RequestParam String product_id,
            @RequestParam Date store_date,
            @RequestParam Date sales_date,
            @RequestParam float price,
            Model model
    ) {
        salesRepository.insertNewSale(new Sale(product_id, store_date, sales_date, price));
        model.addAttribute("sellerName", sellerManagementService.getSellerName());
        model.addAttribute("sales", salesRepository.findAllSales());
        return "working.html";
    }

}
