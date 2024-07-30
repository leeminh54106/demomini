package com.example.miniproject.service.impl;

import com.example.miniproject.dao.ICategoryDao;
import com.example.miniproject.dao.impl.CategoryDaoImpl;
import com.example.miniproject.entity.Category;
import com.example.miniproject.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    ICategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
