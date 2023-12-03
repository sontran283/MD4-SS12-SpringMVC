package com.ra.model.dao.product;

import com.ra.model.dao.category.CategoryDAO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.util.ConnectionDataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Product> findAll() {
        Connection connection = null;
        List<Product> products = new ArrayList<>();
        try {
            connection = ConnectionDataBase.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_SHOW_PRODUCT()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                Category category = categoryDAO.findById(resultSet.getInt("category_id"));
                product.setCategory(category);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return products;
    }

    @Override
    public Product findById(Integer id) {
        Connection connection = null;
        Product product = new Product();
        try {
            connection = ConnectionDataBase.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_FIND_BY_ID_PRODUCT(?)}");
            callableStatement.setInt(1, id);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                product.setProductId(resultSet.getInt("id"));
                product.setProductName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                Category category = categoryDAO.findById(resultSet.getInt("category_id"));
                product.setCategory(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return product;
    }

    @Override
    public boolean saveOrUpdate(Product product) {
        Connection connection = null;
        connection = ConnectionDataBase.openConnection();
        try {
            if (product.getProductId() == 0) {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_ADD_PRODUCT(?,?,?,?)}");
                callableStatement.setString(1, product.getProductName());
                callableStatement.setDouble(2, product.getPrice());
                callableStatement.setInt(3, product.getCategory().getCategoryId());
                int check = callableStatement.executeUpdate();
                if (check > 0) {
                    return true;
                }
            } else {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_EDIT_PRODUCT(?,?,?,?)}");
                callableStatement.setInt(1, product.getProductId());
                callableStatement.setString(2, product.getProductName());
                callableStatement.setDouble(3, product.getPrice());
                callableStatement.setDouble(4, product.getCategory().getCategoryId());
                int check = callableStatement.executeUpdate();
                if (check > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDataBase.closeConnection(connection);
        }
        return false;
    }

    @Override
    public void delete(Integer id) {
        Connection connection = null;
        connection = ConnectionDataBase.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_DELETE_PRODUCT(?)}");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
