package com.practice.productspractice.controller;

import com.practice.productspractice.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Stream;

@RequestMapping("/products")
@RestController
public class ProductController {
    List<Product> products = List.of(
            new Product("Apple", 450),
            new Product("Banana", 700),
            new Product("Carrot", 300),
            new Product("Tomato", 600),
            new Product("Orange", 800),
            new Product("Cucumber", 400),
            new Product("Grapes", 1200),
            new Product("Potato", 200),
            new Product("Beef", 4500),
            new Product("Chicken", 2000),
            new Product("Pork", 3000),
            new Product("Milk", 500),
            new Product("Cheese", 1500),
            new Product("Yogurt", 800)
    );

    @GetMapping
    public List<Product> getProducts(@RequestParam(required = false) Integer from, @RequestParam(required = false) Integer to) {
        Stream<Product> currentStream = products.stream();

        if (from != null) {
            currentStream = currentStream.filter(product -> product.getPrice() > from);
        }

        if (to != null) {
            currentStream = currentStream.filter(product -> product.getPrice() < to);
        }

        return currentStream.toList();
    }
    //   /products?from=500&to=1000  - все товары от 500 до 1000
    //   /products?from=500          - все товары от 500
    //   /products?to=1000           - все товары до 1000
    //   /products                   - все товары
    //  Сервис не нужно создавать
}

