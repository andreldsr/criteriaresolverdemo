package com.github.andreldsr.criteriaresolverdemo.searchobject;

import com.github.andreldsr.criteriaresolver.annotation.CriteriaField;
import com.github.andreldsr.criteriaresolver.searchobject.SearchObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategorySearchObject extends SearchObject {
    @CriteriaField
    private String name;
}
