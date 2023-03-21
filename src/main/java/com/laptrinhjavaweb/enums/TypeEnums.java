package com.laptrinhjavaweb.enums;

public enum TypeEnums {
    TANG_TRET("Tầng trệt"), NGUYEN_CAN("Nguyên căn"), NOI_THAT("Nội thất");

    private String value;

    private TypeEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
