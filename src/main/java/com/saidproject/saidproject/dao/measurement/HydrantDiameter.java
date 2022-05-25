package com.saidproject.saidproject.dao.measurement;

import io.swagger.annotations.ApiModel;

import java.util.Arrays;

@ApiModel
public enum HydrantDiameter {

    DN25("DN25"), DN33("DN33"), DN52("DN52"),
    DN80("DN80"), DN100("DN100"), DN150("DN150"),
    DN200("DN200"), UNDEFINED("UNDEFINED");

    private String value;

    private HydrantDiameter(String value) {
        this.value = value;
    }

}
