package com.saidproject.saidproject.dao.measurement;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum HydrantType {

    INSIDE("INSIDE"), OUTSIDE("OUTSIDE"), UNDEFINED("UNDEFINED");

    private String value;

    private HydrantType(String value) {
        this.value = value;
    }
}
