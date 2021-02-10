package com.example.codeclan.whisky.controllers;

import com.example.codeclan.whisky.models.Whisky;
import com.example.codeclan.whisky.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name="year", required = false) Integer year,
            @RequestParam(name="distillery", required = false) Long distillery,
            @RequestParam(name="age", required = false) Integer age,
            @RequestParam(name="region", required = false) String region
    ){
        if (year != null){
            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
        }
        if (distillery != null && age != null){
            return new ResponseEntity<>(whiskyRepository.findByDistilleryIdAndAge(distillery, age), HttpStatus.OK);
        }
        if (region != null) {
            return new ResponseEntity<>(whiskyRepository.findByDistilleryRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }
}
