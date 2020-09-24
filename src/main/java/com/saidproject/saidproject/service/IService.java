package com.saidproject.saidproject.service;

import com.saidproject.saidproject.repo.AbstractEntity;

import java.util.List;

public interface IService <T extends AbstractEntity> {
    T findById(int id);

    List<T> findAll();

    void save(T entity);

    void update(T entity);

    void delete(Integer id);
}
