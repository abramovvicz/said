package com.saidproject.saidproject.dao.measurement;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.repo.AbstractEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Measurement extends AbstractEntity {

    private String title;

    private String address;

    private HydrantType hydrantType;

    private HydrantSubType hydrantSubType;

    private HydrantDiameter hydrantDiameter;

    private List<Description> descriptions;

    private byte[] photo;

    private double staticPressure;

    private double dynamicPressure;

    private double hydrantEfficiency;

    public double getStaticPressure() {
        return staticPressure;
    }

    public void setStaticPressure(double staticPressure) {
        this.staticPressure = staticPressure;
    }

    public double getDynamicPressure() {
        return dynamicPressure;
    }

    public void setDynamicPressure(double dynamicPressure) {
        this.dynamicPressure = dynamicPressure;
    }

    public double getHydrantEfficiency() {
        return hydrantEfficiency;
    }

    public void setHydrantEfficiency(double hydrantEfficiency) {
        this.hydrantEfficiency = hydrantEfficiency;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> details) {
        this.descriptions = details;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return Double.compare(that.staticPressure, staticPressure) == 0 && Double.compare(that.dynamicPressure, dynamicPressure) == 0 && Double.compare(that.hydrantEfficiency, hydrantEfficiency) == 0 && Objects.equals(title, that.title) && Objects.equals(address, that.address) && hydrantType == that.hydrantType && hydrantSubType == that.hydrantSubType && hydrantDiameter == that.hydrantDiameter && Objects.equals(descriptions, that.descriptions) && Arrays.equals(photo, that.photo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(title, address, hydrantType, hydrantSubType, hydrantDiameter, descriptions, staticPressure, dynamicPressure, hydrantEfficiency);
        result = 31 * result + Arrays.hashCode(photo);
        return result;
    }

    @Override
    public String toString() {
        return "Measurement{" + "title='" + title + '\'' + ", address='" + address + '\'' + ", hydrantType=" + hydrantType + ", hydrantSubType=" + hydrantSubType + ", hydrantDiameter=" + hydrantDiameter + ", descriptions=" + descriptions + ", photo=" + Arrays.toString(photo) + ", staticPressure=" + staticPressure + ", dynamicPressure=" + dynamicPressure + ", hydrantEfficiency=" + hydrantEfficiency + '}';
    }
}
