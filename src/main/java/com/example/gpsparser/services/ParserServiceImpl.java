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
                input.toCharArray()[5] == '\'' &&
                input.toCharArray()[8] == '.';
    }

    @Override
    public double parseFromDegreesWithDecimalMinutes(String input) {
        String degrees = input.substring(0, 2);
        String minutes = input.substring(3, input.length() - 2);
        double degreesNum = Double.parseDouble(degrees);
        double minutesNum = Double.parseDouble(minutes);
        return degreesNum + (minutesNum / 60);
    }

    @Override
    public double parseFromDegreesMinutesSeconds(String input) {
        String degrees = input.substring(0, 2);
        String minutes = input.substring(3, 4);
        String seconds = input.substring(6, 9);
        double degreesNum = Double.parseDouble(degrees);
        double minutesNum = Double.parseDouble(minutes);
        double secondsNum = Double.parseDouble(seconds);
        return degreesNum + (minutesNum / 60) + (secondsNum / 3600);
    }

    @Override
    public double parseFromDecimalDegrees(String input) {
        return Double.parseDouble(input);
    }

    @Override
    public boolean isInputValid(String input) {
        return input.contains("^[0-9.°']");
    }
}
