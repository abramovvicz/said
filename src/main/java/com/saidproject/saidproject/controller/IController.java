package com.saidproject.saidproject.controller;

import com.saidproject.saidproject.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;

public interface IController<T, U extends AbstractEntity> {
    ResponseEntity<T> findById(Integer id) throws NotFoundException;

    ResponseEntity<T> findAll() throws NotFoundException;

    ResponseEntity<T> save(U entity);

    ResponseEntity<T> update(U entity);

    ResponseEntity<T> delete(Integer id);
}
