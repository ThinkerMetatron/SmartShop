package com.example.SmartShop;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SmartShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartShopApplication.class, args);
    }

    // Bean має бути ТУТ — у тілі класу, але після методу main
    @Bean
    CommandLineRunner initDatabase(SmartphoneRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Smartphone("iPhone 15 Pro", "Apple", 45000, "📱"));
                repository.save(new Smartphone("Samsung S24 Ultra", "Samsung", 42000, "📱"));
                repository.save(new Smartphone("Hotwav Cyber 13", "Hotwav", 8500, "🛡️"));
                // Додай інші моделі тут
                System.out.println("База даних наповнена смартфонами!");
            }
        };
    }
}