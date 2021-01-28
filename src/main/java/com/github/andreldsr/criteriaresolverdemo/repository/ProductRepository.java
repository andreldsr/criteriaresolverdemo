package com.github.andreldsr.criteriaresolverdemo.repository;

import com.github.andreldsr.criteriaresolverdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}
