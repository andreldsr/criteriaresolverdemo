package com.github.andreldsr.criteriaresolverdemo.controller;

import com.github.andreldsr.criteriaresolverdemo.model.Category;
import com.github.andreldsr.criteriaresolverdemo.searchobject.CategorySearchObject;
import com.github.andreldsr.criteriaresolverdemo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }

    @PostMapping("/findByCriteria")
    public ResponseEntity<List<Category>> getByCriteria(@RequestBody CategorySearchObject categorySearchObject){
        return ResponseEntity.ok(categoryService.getCategoryByCriteria(categorySearchObject));
    }
}
