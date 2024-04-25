package com.example.demo.controllers;

import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/buyProduct")
public class BuyProductController {

    private final ProductService productService;

    @Autowired
    public BuyProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String buyProductPage(Model model) {
        return "mainscreen";
    }

    @PostMapping("/process")
    public String processBuyProduct(@RequestParam("productId") Long productId) {
        boolean isSuccessful = productService.decrementProductInventory(productId);
        if (isSuccessful) {
            return "purchasesuccess";
        } else {
            return "purchaseerror";
        }
    }
}