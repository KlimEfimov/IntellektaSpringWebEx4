package com.example.intellektaspringwebex4.services;

import com.example.intellektaspringwebex4.services.SellerManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {

    private String sellerName;

    private final SellerManagementService sellerManagementService;

    public LoginProcessor(SellerManagementService sellerManagementService) {
        this.sellerManagementService = sellerManagementService;
    }

    public boolean login() {
        sellerManagementService.setSellerName(sellerName);
        return true;
    }

}
