package com.ra.model.service;

import com.ra.model.entity.Customer;

import java.util.List;

public interface ICutomerService extends IGenericService<Customer, Integer> {
    List<Customer> findByName(String name);
}
