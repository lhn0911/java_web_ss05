package com.rikkei.ss05.service;

import com.rikkei.ss05.dao.CategoriesDAO;
import com.rikkei.ss05.dao.CategoriesDAOImp;
import com.rikkei.ss05.model.Categories;


import java.util.List;

public class CategoriesServiceImp implements CategoriesService {
    private final CategoriesDAO categoriesDAO;

    public CategoriesServiceImp() {
        categoriesDAO = new CategoriesDAOImp();
    }

    @Override
    public List<Categories> findAll() {
        return categoriesDAO.findAll();
    }

    @Override
    public boolean save(Categories catalog) {
        return categoriesDAO.save(catalog);
    }
}
