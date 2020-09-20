package com.saidproject.saidproject.repo;

import java.util.List;

public interface IRepo <T extends AbstractEntity> {
    T findById (int id);
    List<T> findAll();
    void save (T entity);
    void update (T entity);
    void delete (int id);
}
