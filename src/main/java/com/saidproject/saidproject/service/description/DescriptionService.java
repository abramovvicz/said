package com.saidproject.saidproject.service.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.repo.description.IDescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionService implements IDescriptionService {

    @Autowired
    private IDescriptionRepo descriptionRepo;

    @Override
    public Description findById(int id) {
        return descriptionRepo.findById(id);
    }

    @Override
    public List<Description> findAll() {
        return descriptionRepo.findAll();
    }

    @Override
    public List<Description> findAllForMeasurement(int id) {
        return descriptionRepo.findAllForMeasurement(id);
    }

    @Override
    public void saveAll(List<Description> descriptions) {
        descriptionRepo.saveAll(descriptions);
    }

    @Override
    public void save(Description entity) {
        descriptionRepo.save(entity);
    }

    @Override
    public void update(Description entity) {
        descriptionRepo.update(entity);
    }

    @Override
    public void delete(Integer id) {
        descriptionRepo.delete(id);
    }
}
