package com.example.gpsparser.services;

import org.springframework.stereotype.Service;

@Service
public class ParserServiceImpl implements ParserService {

    @Override
    public boolean isDecimalDegrees(String input) {
        return input.toCharArray()[2] == '.';
    }

    @Override
    public boolean isDegreesWithDecimalMinutes(String input) {
        return input.toCharArray()[2] == '°' &&
                input.toCharArray()[5] == '.';
    }

    @Override
    public boolean isDegreesMinutesSeconds(String input) {
        return input.toCharArray()[2] == '°' &&
                input.toCharArray()[5] == '\'';
    }

    @Override
    public double parseFromDegreesWithDecimalMinutes(String input) {
        return 0;
    }

    @Override
    public double parseFromDegreesMinutesSeconds(String input) {
        return 0;
    }

    @Override
    public double parseFromDecimalDegrees(String input) {
        return Double.parseDouble(input);
    }
}
