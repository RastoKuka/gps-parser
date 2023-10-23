package com.example.gpsparser.controllers;

import com.example.gpsparser.models.InputDto;
import com.example.gpsparser.services.ParserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ParserService parserService;

    public ApiController(ParserService parserService) {
        this.parserService = parserService;
    }

    @PostMapping("/parse")
    public ResponseEntity<?> parseCoordinates(@RequestBody InputDto inputDto) {
        if (inputDto.getInputLatitude().isEmpty() && inputDto.getInputLongitude().isEmpty()) {
            return ResponseEntity.badRequest().body("Provide at least one coordinate!");
        } else if (!parserService.isInputValid(inputDto.getInputLongitude()) ||
                !parserService.isInputValid(inputDto.getInputLatitude())) {
            return ResponseEntity.badRequest().body("Invalid input!");
        }

        String inputLongitude = inputDto.getInputLongitude();
        String inputLatitude = inputDto.getInputLatitude();
        String outputLongitude;
        String outputLatitude;


        if (parserService.isDecimalDegrees(inputLatitude)) {
            outputLatitude = String.valueOf(parserService.parseFromDecimalDegrees(inputLatitude));
        } else if (parserService.isDegreesWithDecimalMinutes(inputLatitude)) {
            outputLatitude = String.valueOf(parserService.parseFromDegreesWithDecimalMinutes(inputLatitude));
        } else {
            outputLatitude = String.valueOf(parserService.parseFromDegreesMinutesSeconds(inputLatitude));
        }

        if (parserService.isDecimalDegrees(inputLongitude)) {
            outputLongitude = String.valueOf(parserService
                    .parseFromDecimalDegrees(inputLongitude));
        } else if (parserService.isDegreesWithDecimalMinutes(inputLongitude)) {
            outputLongitude = String.valueOf(parserService
                    .parseFromDegreesWithDecimalMinutes(inputLongitude));
        } else {
            outputLongitude = String.valueOf(parserService
                    .parseFromDegreesMinutesSeconds(inputLongitude));
        }

        return ResponseEntity.ok().body("Longitude: " + outputLongitude +
                "\nLatitude: " + outputLatitude);
    }
}
