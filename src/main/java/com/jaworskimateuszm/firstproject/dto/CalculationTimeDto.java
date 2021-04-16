package com.jaworskimateuszm.firstproject.dto;

public class CalculationTimeDto {

    private String name;
    private long time;

    public CalculationTimeDto(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
