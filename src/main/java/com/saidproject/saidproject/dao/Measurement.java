package com.saidproject.saidproject.dao;

import java.util.Date;
import java.util.Objects;

public class Measurement {

    private int id;
    private String address;
    private HydrantType hydrantType;
    private HydrantSubType hydrantSubType;
    private HydrantDiameter hydrantDiameter;
    private Date dateOfMeasurement;

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

    public HydrantType getHydrantType() {
        return hydrantType;
    }

    public void setHydrantType(HydrantType hydrantType) {
        this.hydrantType = hydrantType;
    }

    public HydrantSubType getHydrantSubType() {
        return hydrantSubType;
    }

    public void setHydrantSubType(HydrantSubType hydrantSubType) {
        this.hydrantSubType = hydrantSubType;
    }

    public HydrantDiameter getHydrantDiameter() {
        return hydrantDiameter;
    }

    public void setHydrantDiameter(HydrantDiameter hydrantDiameter) {
        this.hydrantDiameter = hydrantDiameter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return address.equals(that.address) &&
                hydrantType == that.hydrantType &&
                hydrantSubType == that.hydrantSubType &&
                hydrantDiameter == that.hydrantDiameter &&
                dateOfMeasurement.equals(that.dateOfMeasurement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, hydrantType, hydrantSubType, hydrantDiameter, dateOfMeasurement);
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", hydrantType=" + hydrantType +
                ", hydrantSubType=" + hydrantSubType +
                ", hydrantDiameter=" + hydrantDiameter +
                ", dateOfMeasurement=" + dateOfMeasurement +
                '}';
    }
}
