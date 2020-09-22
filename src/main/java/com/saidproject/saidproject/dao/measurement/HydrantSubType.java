package com.saidproject.saidproject.dao.measurement;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum HydrantSubType {

    UNDERGROUND("UNDERGROUND"), GROUND("GROUND"), UNDEFINED("UNDEFINED");

    private String value;

    private HydrantSubType(String value) {
        this.value = value;
    }
}
