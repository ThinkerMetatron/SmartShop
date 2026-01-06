package com.example.SmartShop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
    
    // Пошук за брендом
    List<Smartphone> findByBrand(String brand);

    // Сортування за ціною (від дешевих до дорогих)
    List<Smartphone> findAllByOrderByPriceAsc();

    // Сортування за ціною (від дорогих до дешевих)
    List<Smartphone> findAllByOrderByPriceDesc();
    List<Smartphone> findByNameContainingIgnoreCase(String name);
}