package com.example.gpsparser.services;

import org.springframework.stereotype.Service;

@Service
public class ParserServiceImpl implements ParserService {
    @Override
    public boolean isDecimalDegrees(String input) {
        char[] chars = input.toCharArray();
        if (chars[2] == '.') {
            return true;
        }
        return false;
    }

    @Override
    public boolean isDegreesWithDecimalMinutes(String input) {
        return false;
    }

    @Override
    public boolean isDegreesMinutesSeconds(String input) {
        return false;
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
