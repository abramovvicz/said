package com.saidproject.saidproject.service;

import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.repo.AbstractEntity;

import java.util.List;

public interface IService<T extends AbstractEntity> {
    T findById(int id) throws NotFoundException;

    List<T> findAll() throws NotFoundException;

    T saveDescription(T entity);

    T update(T entity);

    boolean delete(Integer id);
}
