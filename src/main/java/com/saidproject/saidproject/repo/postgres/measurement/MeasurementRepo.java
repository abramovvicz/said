package com.saidproject.saidproject.repo.postgres.measurement;

import com.saidproject.saidproject.dao.measurement.Measurement;
import com.saidproject.saidproject.repo.api.IMeasurementRepo;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MeasurementRepo extends IMeasurementRepo {

}
