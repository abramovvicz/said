package com.saidproject.saidproject.controller;

import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.repo.AbstractEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IController<T extends AbstractEntity> {
    ResponseEntity<T> findById(Integer id) throws NotFoundException;

    ResponseEntity<List<T>> findAll() throws NotFoundException;

    ResponseEntity<T> save(T entity);

    ResponseEntity update(T entity);

    ResponseEntity delete(Integer id);
}
