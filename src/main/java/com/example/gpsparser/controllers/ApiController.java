package com.example.gpsparser.controllers;

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
    public ResponseEntity<?> parseCoordinates(@RequestBody ){

    }
}
