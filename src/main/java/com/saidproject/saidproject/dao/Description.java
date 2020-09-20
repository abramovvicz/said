package com.saidproject.saidproject.dao;

import com.saidproject.saidproject.repo.AbstractEntity;

public class Description extends AbstractEntity {

    private int measurementId;

    private String name;

    private int status;

    private String comments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(int measurementId) {
        this.measurementId = measurementId;
    }

    @Override
    public String toString() {
        return "Description{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", comments='" + comments + '\'' +
                '}';
    }

}
