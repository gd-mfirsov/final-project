package com.mfirsov.shop.controller;

import com.mfirsov.shop.model.Product;
import com.mfirsov.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(path = "/product",
                 consumes = MediaType.APPLICATION_JSON_VALUE,
                 produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody Product createProduct(@Valid @RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping(path = "/products",
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @GetMapping(path = "/product/detail/{id}",
                produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody Product getProduct(@PathVariable Long id) {
        return productRepository.findById(id).orElse(null);
    }

}
