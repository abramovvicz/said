package com.saidproject.saidproject.repo.api;

import com.saidproject.saidproject.dao.measurement.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface IMeasurementRepo extends JpaRepository<Measurement, Integer> {
}
