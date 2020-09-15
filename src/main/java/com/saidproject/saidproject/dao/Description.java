package com.saidproject.saidproject.dao;

public class Description {

    private int id;

    private int measurementId;

    public int getMeasurementId() {
        return measurementId;
    }

    public void setMeasurementId(int measurementId) {
        this.measurementId = measurementId;
    }

    private String name;

    private int status;

    private String comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Description{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", comments='" + comments + '\'' +
                '}';
    }

}
