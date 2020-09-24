package com.saidproject.saidproject.controller;

import com.saidproject.saidproject.repo.AbstractEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IController <T extends AbstractEntity> {
    ResponseEntity<T> findById (int id);
    ResponseEntity<List<T>> findAll();
    void save (T entity);
    void update (T entity);
    void delete (Integer id);
}
