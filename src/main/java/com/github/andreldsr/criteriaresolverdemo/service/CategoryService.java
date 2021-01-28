package com.github.andreldsr.criteriaresolverdemo.service;

import com.github.andreldsr.criteriaresolverdemo.criteriarepository.CategoryCriteriaRepository;
import com.github.andreldsr.criteriaresolverdemo.model.Category;
import com.github.andreldsr.criteriaresolverdemo.repository.CategoryRepository;
import com.github.andreldsr.criteriaresolverdemo.searchobject.CategorySearchObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryCriteriaRepository categoryCriteriaRepository;

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public List<Category> getCategoryByCriteria(CategorySearchObject categorySearchObject){
        return categoryCriteriaRepository.getResultList(categorySearchObject);
    }
}
