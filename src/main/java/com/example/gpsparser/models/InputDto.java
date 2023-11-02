package com.example.gpsparser.models;

public class InputDto {
    private final String inputLongitude;
    private final String inputLatitude;

    public InputDto(String inputLongitude, String inputLatitude) {
        this.inputLongitude = inputLongitude;
        this.inputLatitude = inputLatitude;
    }

    public String getInputLongitude() {
        return inputLongitude;
    }

    public String getInputLatitude() {
        return inputLatitude;
    }
}
