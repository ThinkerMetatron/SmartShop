package com.example.SmartShop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products") // Адреса, за якою JS буде брати дані
public class SmartphoneController {

    @Autowired
    private SmartphoneRepository repository;

    @GetMapping
    public List<Smartphone> getProducts(@RequestParam(required = false) String sort, 
                                        @RequestParam(required = false) String brand,
                                        @RequestParam(required = false) String search) {
        if (brand != null && !brand.isEmpty()) {
            return repository.findByBrand(brand);
        }
        
        if (search != null && !search.isEmpty()) {
            return repository.findByNameContainingIgnoreCase(search);
        }
        if ("priceAsc".equals(sort)) {
            return repository.findAllByOrderByPriceAsc();
        } else if ("priceDesc".equals(sort)) {
            return repository.findAllByOrderByPriceDesc();
        }
       
        
        return repository.findAll(); // За замовчуванням
    }
}