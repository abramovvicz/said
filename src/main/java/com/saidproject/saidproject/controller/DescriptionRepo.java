package com.saidproject.saidproject.controller;

import com.saidproject.saidproject.dao.Description;
import com.saidproject.saidproject.repo.description.IDescription;

import java.util.List;

public class DescriptionRepo implements IDescription {
    @Override
    public List<Description> findAllByMeasurementId(Integer id) {
        //
        return null;
    }
}
