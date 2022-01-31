package com.justintu.constants;

public enum RedemptionType {
    SINGLE_REDEMPTION("SR"), MULTIPLE_REDEMPTION("MR"),
    X_TIMES_REDEMPTION("XR"), TIME_REDEMPTION("TR");

    private String redemptionCode;

    RedemptionType(String redemptionCode) {
        this.redemptionCode = redemptionCode;
    }
}
