package com.rikkei.ss05.service;


import com.rikkei.ss05.model.Categories;

import java.util.List;

public interface CategoriesService {
    List<Categories> findAll();

    boolean save(Categories catalog);
}
