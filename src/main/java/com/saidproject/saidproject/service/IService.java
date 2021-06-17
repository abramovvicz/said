package com.saidproject.saidproject.service;

import com.saidproject.saidproject.exceptions.NotFoundException;

import java.util.List;

public interface IService<T extends AbstractEntity> {
    T findById(int id) throws NotFoundException;

    List<T> findAll() throws NotFoundException;

    T save(T entity);

    boolean update(T entity);

    boolean delete(Integer id);
}
