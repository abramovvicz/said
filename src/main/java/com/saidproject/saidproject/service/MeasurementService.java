package com.saidproject.saidproject.service;

import com.saidproject.saidproject.dao.Description;
import com.saidproject.saidproject.dao.Measurement;
import com.saidproject.saidproject.repo.description.DescriptionRepo;
import com.saidproject.saidproject.repo.measurement.MeasurementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeasurementService {

    @Autowired
    private MeasurementRepo measurementRepo;

    @Autowired
    private DescriptionRepo descriptionRepo;

    public void save(Measurement measurement) {
        measurementRepo.save(measurement);
        List<Description> descriptions = measurement.getDescriptions();
        descriptionRepo.saveAll(descriptions);
    }

    public List<Measurement> findAll() {
        return measurementRepo.findAll();
    }

    public Measurement findById(int id) {
        return measurementRepo.findById(id);
    }

    public void update(Measurement measurement) {
        measurementRepo.update(measurement);
    }

    public void delete(int id) {
        measurementRepo.delete(id);
    }
}
