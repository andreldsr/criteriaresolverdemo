package com.github.andreldsr.criteriaresolverdemo.searchobject;

import com.github.andreldsr.annotation.CriteriaField;
import com.github.andreldsr.searchobject.SearchObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSearchObject extends SearchObject {
    @CriteriaField(comparationType = CriteriaField.ComparationType.LIKE)
    private String name;
    @CriteriaField(comparationType = CriteriaField.ComparationType.LIKE)
    private String description;
    @CriteriaField(fieldName = "price", comparationType = CriteriaField.ComparationType.GREATER_EQUALS)
    private Double minPrice;
    @CriteriaField(fieldName = "price", comparationType = CriteriaField.ComparationType.LESS_EQUALS)
    private Double maxPrice;
    @CriteriaField(fieldName = "price")
    private Double exactPrice;
    @CriteriaField(fieldName = "category.name", comparationType = CriteriaField.ComparationType.LIKE)
    private String category;
}
