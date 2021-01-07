package com.saidproject.saidproject.dao.measurement;

import io.swagger.annotations.ApiModel;

@ApiModel
public enum HydrantDiameter {

    DN25_DR10("DN25/DR10"),
    DN33_DR12("DN33/DR12"),
    DN52_DR13("DN52/DR13"),
    DN80_DP22("DN80/DP22"),
    DN80_DP26("DN80/DP26"),
    DN100_DP32("DN100/DP32"),
    DN150_DP37("DN150/DP37"),
    UNDEFINED("UNDEFINED");

    private String value;

    private HydrantDiameter(String value) {
        this.value = value;
    }

}
