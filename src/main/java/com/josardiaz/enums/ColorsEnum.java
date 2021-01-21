package com.josardiaz.enums;

public enum ColorsEnum {
    RED("RED"),
    BLACK("BLACK");

    private final String color;

    ColorsEnum(String color) {
        this.color = color;
    }
    public String getColor() {
        return color;
    }


}
