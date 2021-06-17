package com.saidproject.saidproject.service.measurement;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.dao.measurement.Measurement;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.repo.api.IDescriptionRepo;
import com.saidproject.saidproject.repo.api.IMeasurementRepo;
import com.saidproject.saidproject.utils.Chart;
import com.saidproject.saidproject.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class MeasurementService implements  IMeasurementService{

    @Autowired
    private IMeasurementRepo measurementRepo;

    @Autowired
    private IDescriptionRepo descriptionRepo;

    public Measurement save(Measurement measurement) {
        Measurement insertedMeasurement = measurementRepo.save(measurement);
        List<Description> descriptions = measurement.getDescriptions();
        assignParentMeasurementId(descriptions, insertedMeasurement.getId());
        descriptionRepo.saveAll(descriptions);

        /**
         * temporary creating chart from measurements
         * TODO:move to implemantion where pdf is genereted
         *
         */

        double staticPressure = measurement.getStaticPressure();
        double dynamicPressure = measurement.getDynamicPressure();
        double hydrantEfficiency = measurement.getHydrantEfficiency();

        Chart chart = new Chart();
        chart.setYData(new double[]{staticPressure, dynamicPressure});
        chart.setXData(new double[]{Constants.START_POINT_MEASUREMENT, hydrantEfficiency});
        try {
            chart.createChart();
        } catch (IOException e) {
            e.printStackTrace();
        }


        /**
         * end
         */
        return insertedMeasurement;
    }

    private void assignParentMeasurementId(List<Description> descriptions, Integer measurementParentId) {
//        descriptions.forEach(description -> description.setProtocolId(measurementParentId));
    }

    public List<Measurement> findAll() throws NotFoundException {
        List<Measurement> measurements = measurementRepo.findAll();
        if (measurements.isEmpty()) {
            throw new NotFoundException("Measurements not found");
        }
        return measurements;
    }

    public Measurement findById(int id) throws NotFoundException {
        Measurement measurement = measurementRepo.findById(id);
        if (measurement == null) {
            throw new NotFoundException("Measurement not found");
        }
        return measurement;
    }

    public boolean update(Measurement measurement) {
        return measurementRepo.update(measurement);
    }

    public boolean delete(Integer id) {
        return measurementRepo.delete(id);
    }
}
