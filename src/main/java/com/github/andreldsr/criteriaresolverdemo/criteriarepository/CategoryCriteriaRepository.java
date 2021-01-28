package com.github.andreldsr.criteriaresolverdemo.criteriarepository;

import com.github.andreldsr.criteriaresolverdemo.model.Category;
import com.github.andreldsr.criteriaresolver.repository.CriteriaBaseRepository;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;

@Repository
public class CategoryCriteriaRepository extends CriteriaBaseRepository<Category> {
    public CategoryCriteriaRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
