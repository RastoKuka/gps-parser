package com.example.gpsparser.services;

public interface ParserService {
    boolean isDecimalDegrees(String input);

    boolean isDegreesWithDecimalMinutes(String input);

    boolean isDegreesMinutesSeconds(String input);

    double parseFromDegreesWithDecimalMinutes(String input);

    double parseFromDegreesMinutesSeconds(String input);

    double parseFromDecimalDegrees(String input);
    boolean isInputValid(String input);

}
