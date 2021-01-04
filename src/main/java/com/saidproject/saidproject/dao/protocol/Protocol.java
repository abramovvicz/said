package com.saidproject.saidproject.dao.protocol;

import com.saidproject.saidproject.dao.measurement.Measurement;
import com.saidproject.saidproject.repo.AbstractEntity;

import java.util.List;
import java.util.Objects;

public class Protocol extends AbstractEntity {

    private String title;

    private List<Measurement> measurements;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(List<Measurement> measurements) {
        this.measurements = measurements;
    }

    @Override
    public String toString() {
        return "Protocol{" + "title='" + title + '\'' + ", measurements=" + measurements + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Protocol protocol = (Protocol) o;
        return Objects.equals(title, protocol.title) && Objects.equals(measurements, protocol.measurements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, measurements);
    }
}
