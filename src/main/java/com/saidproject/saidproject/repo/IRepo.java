package com.saidproject.saidproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRepo <T extends AbstractEntity>  extends JpaRepository<T, Integer> {
//    T findById (int id);
//    List<T> findAll();
//    T saveDescription(T entity);
//    boolean update (T entity);
//    boolean delete(Integer id);
}
