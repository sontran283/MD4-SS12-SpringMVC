package com.ra.model.service;

import com.ra.model.dao.CutomerDAOImpl;
import com.ra.model.dao.ICutomerDAO;
import com.ra.model.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CutomerServiceImpl implements ICutomerService {

    @Autowired
    ICutomerDAO cutomerDAO;

    @Override
    public List<Customer> findByName(String name) {
        return cutomerDAO.findByName(name);
    }

    @Override
    public List<Customer> findAll() {
        return cutomerDAO.findAll();
    }

    @Override
    public boolean save(Customer customer) {
        return cutomerDAO.save(customer);
    }

    @Override
    public void delete(Integer integer) {
        cutomerDAO.delete(integer);
    }

    @Override
    public Customer findById(Integer integer) {
        return cutomerDAO.findById(integer);
    }
}
