package com.github.andreldsr.criteriaresolverdemo.dto;

import com.github.andreldsr.annotation.ProjectionField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @ProjectionField(projectionPath = "name")
    private String productName;
    private Double price;
    @ProjectionField(projectionPath = "category.name")
    private String categoryName;
}
