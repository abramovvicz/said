package com.saidproject.saidproject.service.measurement;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.dao.measurement.Measurement;
import com.saidproject.saidproject.repo.description.IDescriptionRepo;
import com.saidproject.saidproject.repo.measurement.IMeasurementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MeasurementService implements  IMeasurementService{

    @Autowired
    private IMeasurementRepo measurementRepo;

    @Autowired
    private IDescriptionRepo descriptionRepo;

    public boolean save(Measurement measurement) {
        boolean measurementSaved = measurementRepo.save(measurement);
        List<Description> descriptions = measurement.getDescriptions();
        boolean descriptionsSaved = descriptionRepo.saveAll(descriptions);
        return measurementSaved && descriptionsSaved;
    }

    public List<Measurement> findAll() {
        return measurementRepo.findAll();
    }

    public Measurement findById(int id) {
        return measurementRepo.findById(id);
    }

    public boolean update(Measurement measurement) {
        return measurementRepo.update(measurement);
    }

    public boolean delete(Integer id) {
        return measurementRepo.delete(id);
    }
}
