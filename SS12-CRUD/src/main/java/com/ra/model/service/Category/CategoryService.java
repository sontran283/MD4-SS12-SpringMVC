package com.ra.model.service.Category;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    boolean saveOrUpdate(Category category);

    void delete(Integer id);
}
