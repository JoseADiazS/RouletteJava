package com.josardiaz.enums;

public enum TypeEnum {
    NUMBER("number"),
    COLOR("color");

    private final String value;

    TypeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
