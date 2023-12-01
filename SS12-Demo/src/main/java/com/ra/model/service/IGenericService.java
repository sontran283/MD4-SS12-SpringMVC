package com.ra.model.service;

import java.util.List;

public interface IGenericService<T, ID> {
    List<T> findAll();

    boolean save(T t);

    void delete(ID id);

    T findById(ID id);
}
