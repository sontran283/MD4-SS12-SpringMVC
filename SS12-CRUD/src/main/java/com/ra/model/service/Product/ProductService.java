package com.ra.model.service.Product;

import com.ra.model.entity.Category;
import com.ra.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Integer id);

    boolean saveOrUpdate(Product product);

    void delete(Integer id);
}
