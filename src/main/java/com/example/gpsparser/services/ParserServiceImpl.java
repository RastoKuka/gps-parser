package com.example.gpsparser.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        String seconds;

        if ((input.length() > 8) && (input.charAt(8) == '.')) {
            seconds = input.substring(6, input.length() - 1);
        } else {
            seconds = input.substring(6, 7);
        }

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
        List<String> inList = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            inList.add(String.valueOf(input.charAt(i)));
        }
        for (String s : inList) {
            if (!s.matches("[0-9.°'\"]")) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isNegative(String input) {
        return input.startsWith("-");
    }
}
