package com.saidproject.saidproject.dao.measurement.document;

import java.util.Map;

public class MeasurementFieldDocument {


    private Map<String,String> headerFooter;

    private Map<String, String> firsPage;

    private Map<String, String> secondPage;

    public Map<String, String> getHeaderFooter() {
        return headerFooter;
    }

    public void setHeaderFooter(Map<String, String> headerFooter) {
        this.headerFooter = headerFooter;
    }

    public Map<String, String> getFirsPage() {
        return firsPage;
    }

    public void setFirsPage(Map<String, String> firsPage) {
        this.firsPage = firsPage;
    }

    public Map<String, String> getSecondPage() {
        return secondPage;
    }

    public void setSecondPage(Map<String, String> secondPage) {
        this.secondPage = secondPage;
    }

    @Override
    public String toString() {
        return "MeasurementFieldDocument{" +
                "headerFooter=" + headerFooter +
                ", firsPage=" + firsPage +
                ", secondPage=" + secondPage +
                '}';
    }
}
