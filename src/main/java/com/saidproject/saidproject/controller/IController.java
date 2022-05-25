package com.saidproject.saidproject.controller;

import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.repo.AbstractEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface IController<T, U extends AbstractEntity> {
    ResponseEntity<T> findById(int id) throws NotFoundException;

    ResponseEntity<T> findAll() throws NotFoundException;

    ResponseEntity<T> save(U entity);

    ResponseEntity<T> update(U entity);

    ResponseEntity<T> delete(Integer id);
}
