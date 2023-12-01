package com.ra.model.service.Product;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.dao.product.ProductDAO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> findAll() {
        return productDAO.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productDAO.findById(id);
    }

    @Override
    public boolean saveOrUpdate(Product product) {
        return productDAO.saveOrUpdate(product);
    }

    @Override
    public void delete(Integer id) {
        productDAO.delete(id);
    }
}
