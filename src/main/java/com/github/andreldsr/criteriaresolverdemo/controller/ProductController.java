package com.github.andreldsr.criteriaresolverdemo.controller;

import com.github.andreldsr.criteriaresolverdemo.dto.ProductDTO;
import com.github.andreldsr.criteriaresolverdemo.model.Product;
import com.github.andreldsr.criteriaresolverdemo.searchobject.ProductSearchObject;
import com.github.andreldsr.criteriaresolverdemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping("/findByCriteria")
    public ResponseEntity<List<ProductDTO>> getByCriteria(@RequestBody ProductSearchObject productSearchObject){
        return ResponseEntity.ok(productService.getProductByCriteria(productSearchObject));
    }
}
