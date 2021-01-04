package com.saidproject.saidproject.dao.measurement;

import io.swagger.annotations.ApiModel;

import java.util.Arrays;

@ApiModel
public enum HydrantDiameter {

    DN25("DN25/DR10"), DN33("DN33/DR12"), DN52("DN52/DR13"),
    DN80("DN80/DP22"), DN80B("DN80/DP26"), DN100("DN100/DP32"), DN150("DN150/DP37"),
    DN200("DN200/DP"), UNDEFINED("UNDEFINED");

    private String value;

    private HydrantDiameter(String value) {
        this.value = value;
    }

}
