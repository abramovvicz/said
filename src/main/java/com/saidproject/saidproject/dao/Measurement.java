package com.saidproject.saidproject.dao;

import java.util.Date;

public class Measurement {

    int id;
    String address;
    Date dateOfMeasurement;
    HydrantType typeOfHydrant;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfMeasurement() {
        return dateOfMeasurement;
    }

    public void setDateOfMeasurement(Date dateOfMeasurement) {
        this.dateOfMeasurement = dateOfMeasurement;
    }
}
