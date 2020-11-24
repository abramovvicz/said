package com.saidproject.saidproject.dao.description;

import com.saidproject.saidproject.repo.AbstractEntity;

import java.util.Objects;

public class Description extends AbstractEntity {

    private int measurementId;

    private String name;

    private String status;

    private String comments;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Description that = (Description) o;
        return measurementId == that.measurementId &&
                status == that.status &&
                name.equals(that.name) &&
                comments.equals(that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(measurementId, name, status, comments);
    }
}
