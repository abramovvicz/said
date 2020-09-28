package com.saidproject.saidproject.repo;

import java.util.List;

public interface IRepo <T extends AbstractEntity> {
    T findById (int id);
    List<T> findAll();
    T save (T entity);
    boolean update (T entity);
    boolean delete (Integer id);
}
