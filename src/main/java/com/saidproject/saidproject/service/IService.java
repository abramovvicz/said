package com.saidproject.saidproject.service;

import com.saidproject.saidproject.repo.AbstractEntity;

import java.util.List;

public interface IService <T extends AbstractEntity> {
    T findById(int id);

    List<T> findAll();

    boolean save(T entity);

    boolean update(T entity);

    boolean delete(Integer id);
}
