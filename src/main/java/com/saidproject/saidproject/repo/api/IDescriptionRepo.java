package com.saidproject.saidproject.repo.api;

import com.saidproject.saidproject.dao.description.Description;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

public interface IDescriptionRepo extends JpaRepository<Description, Integer> {
    List<Description> findAllForMeasurement(Integer measurementId);
    List<Description> saveAll (List<Description> descriptionList);
    Description findById(int id);
    Description saveRepo(Description entity);

    boolean update(Description entity);
}
