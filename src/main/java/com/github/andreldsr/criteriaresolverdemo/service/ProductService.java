package com.github.andreldsr.criteriaresolverdemo.service;

import com.github.andreldsr.criteriaresolverdemo.criteriarepository.ProductCriteriaRepository;
import com.github.andreldsr.criteriaresolverdemo.dto.ProductDTO;
import com.github.andreldsr.criteriaresolverdemo.model.Product;
import com.github.andreldsr.criteriaresolverdemo.repository.ProductRepository;
import com.github.andreldsr.criteriaresolverdemo.searchobject.ProductSearchObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductCriteriaRepository productCriteriaRepository;

    public List<Product> getAll(){
        return productRepository.findAll();
    }

    public List<ProductDTO> getProductByCriteria(ProductSearchObject productSearchObject){
        return productCriteriaRepository.getGenericQuery(productSearchObject, ProductDTO.class).getResultList();
    }
}
