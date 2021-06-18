package com.saidproject.saidproject.service.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.repo.api.IDescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescriptionService implements IDescriptionService {

    @Autowired
    private IDescriptionRepo descriptionRepo;

    @Override
    public Description findById(int id) throws NotFoundException {
        Description description = descriptionRepo.findById(id);
        if (description == null){
            throw new NotFoundException("Description with id: " + id + " not found");
        }
        return description;
    }

    @Override
    public List<Description> findAll() throws NotFoundException {
        List<Description> descriptions = descriptionRepo.findAll();
        if(descriptions.isEmpty()){
           throw new NotFoundException("Descriptions not found");
        }
        return descriptions;
    }

    @Override
    public List<Description> findAllForMeasurement(int id) throws NotFoundException {
        List<Description> descriptions = descriptionRepo.findAllForMeasurement(id);
        if(descriptions.isEmpty()){
            throw new NotFoundException("Descriptions for measurement with id: " + id + "not found");
        }
        return descriptions;
    }

    @Override
    public List<Description> saveAll(List<Description> descriptions) {
        return descriptionRepo.saveAll(descriptions);
    }

    @Override
    public Description save(Description entity) {
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
