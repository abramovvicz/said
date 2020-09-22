package com.saidproject.saidproject.dao.measurement;

import com.google.common.base.Objects;
import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.repo.AbstractEntity;

import java.util.List;

public class Measurement extends AbstractEntity {

    private String address;
    private HydrantType hydrantType;
    private HydrantSubType hydrantSubType;
    private HydrantDiameter hydrantDiameter;
    private List<Description> descriptions;
    private byte[] photo;

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

    @Override
    public String toString() {
        return "Measurement{" +
                "id='" + getId() + '\'' +
                "address='" + address + '\'' +
                ", hydrantType=" + hydrantType +
                ", hydrantSubType=" + hydrantSubType +
                ", hydrantDiameter=" + hydrantDiameter +
                ", descriptions=" + descriptions +
                ", createdAt=" + getCreatedAt() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return Objects.equal(address, that.address) &&
                hydrantType == that.hydrantType &&
                hydrantSubType == that.hydrantSubType &&
                hydrantDiameter == that.hydrantDiameter &&
                Objects.equal(descriptions, that.descriptions) &&
                Objects.equal(getCreatedAt(), that.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(address, hydrantType, hydrantSubType, hydrantDiameter, descriptions, getCreatedAt());
    }
}
