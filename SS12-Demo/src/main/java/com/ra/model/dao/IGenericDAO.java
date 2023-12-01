package com.ra.model.dao;

import java.util.List;

public interface IGenericDAO<T, ID> {
    List<T> findAll();

    boolean save(T t);

    void delete(ID id);

    T findById(ID id);
}
