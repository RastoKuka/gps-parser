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
        } else if (parserService.isDecimalDegrees(inputDto.getInputLatitude()) &&
                parserService.isDecimalDegrees(inputDto.getInputLongitude())) {
            return ResponseEntity.status(201).body("Longitude" + parserService.parseFromDecimalDegrees(inputDto.getInputLongitude()) +
                    "Latitude" + parserService.parseFromDecimalDegrees(inputDto.getInputLatitude()));
        }
    }
}
