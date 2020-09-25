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
    public boolean saveAll(List<Description> descriptions) {
        return descriptionRepo.saveAll(descriptions);
    }

    @Override
    public boolean save(Description entity) {
        return descriptionRepo.save(entity);
    }

    @Override
    public boolean update(Description entity) {
        return descriptionRepo.update(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return descriptionRepo.delete(id);
    }
}
