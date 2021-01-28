package com.github.andreldsr.criteriaresolverdemo.criteriarepository;

import com.github.andreldsr.criteriaresolverdemo.model.Product;
import com.github.andreldsr.criteriaresolver.repository.CriteriaBaseRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
public class ProductCriteriaRepository extends CriteriaBaseRepository<Product> {
    public ProductCriteriaRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
