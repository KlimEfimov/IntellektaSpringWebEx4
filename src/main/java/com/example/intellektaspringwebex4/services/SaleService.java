package com.example.intellektaspringwebex4.services;

import com.example.intellektaspringwebex4.models.Sale;
import com.example.intellektaspringwebex4.repositories.SalesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaleService {

    private final SalesRepository salesRepository;

    private List<Sale> sales = new ArrayList<>();

    public SaleService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public void initializeSalesList() {
        sales = salesRepository.findAllSales();
    }

    public List<Sale> getAllSales() {
        return sales;
    }


}
