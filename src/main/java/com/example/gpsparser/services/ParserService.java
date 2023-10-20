package com.example.gpsparser.services;

public interface ParserService {
    public boolean isDecimalDegrees(String input);
    public boolean isDegreesWithDecimalMinutes(String input);
    public boolean isDegreesMinutesSeconds(String input);
    public double parseFromDegreesWithDecimalMinutes(String input);
    public double parseFromDegreesMinutesSeconds(String input);
}
