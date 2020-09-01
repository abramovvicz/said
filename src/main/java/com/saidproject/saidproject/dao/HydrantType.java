package com.saidproject.saidproject.dao;

public enum HydrantType {

    INSIDE, OUTSIDE;

    private HydrantSubType hydrantSubType = HydrantSubType.UNDEFINED;

    public void setHydrantSubType(HydrantSubType hydrantSubType) {
        this.hydrantSubType = hydrantSubType;
    }

    public HydrantSubType getHydrantSubType() {
        return hydrantSubType;
    }
}
