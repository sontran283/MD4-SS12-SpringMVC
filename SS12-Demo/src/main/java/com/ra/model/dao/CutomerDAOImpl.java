package com.ra.model.dao;

import com.ra.model.entity.Customer;
import com.ra.util.ConnectionDB;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CutomerDAOImpl implements ICutomerDAO {
    @Override
    public List<Customer> findByName(String name) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        List<Customer> customers = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_FIND_BY_NAME()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("id"));
                customer.setCustomerName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setEmail(resultSet.getString("email"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return customers;
    }

    @Override
    public List<Customer> findAll() {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        List<Customer> customers = new ArrayList<>();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_SHOW_LIST()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("id"));
                customer.setCustomerName(resultSet.getString("name"));
                customer.setAddress(resultSet.getString("address"));
                customer.setEmail(resultSet.getString("email"));
                customers.add(customer);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return customers;
    }

    @Override
    public boolean save(Customer customer) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        try {
            if (customer.getCustomerId() == 0) {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_CREATE_CUTOMER(?,?,?)}");
                callableStatement.setString(1, customer.getCustomerName());
                callableStatement.setString(2, customer.getAddress());
                callableStatement.setString(3, customer.getEmail());
                int check = callableStatement.executeUpdate();
                if (check > 0) {
                    return true;
                }
            } else {
                CallableStatement callableStatement = connection.prepareCall("{CALL PROC_UPDATE_LIST(?,?,?,?)}");
                callableStatement.setInt(1, customer.getCustomerId());
                callableStatement.setString(2, customer.getCustomerName());
                callableStatement.setString(3, customer.getAddress());
                callableStatement.setString(4, customer.getEmail());
                int check = callableStatement.executeUpdate();
                if (check > 0) {
                    return true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public void delete(Integer integer) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_DELETE_LIST(?)}");
            callableStatement.setInt(1, integer);
            callableStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer findById(Integer integer) {
        Connection connection = null;
        connection = ConnectionDB.openConnection();
        Customer customer = new Customer();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL PROC_FIND_BY_ID(?)}");
            callableStatement.setInt(1, integer);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                customer.setCustomerId(resultSet.getInt("id"));
                customer.setCustomerName(resultSet.getString("name"));
                customer.setEmail(resultSet.getString("address"));
                customer.setAddress(resultSet.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return customer;
    }
}
