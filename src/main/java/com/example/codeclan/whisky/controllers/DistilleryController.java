package com.example.codeclan.whisky.controllers;

import com.example.codeclan.whisky.models.Distillery;
import com.example.codeclan.whisky.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value="distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(
            @RequestParam(name="region", required = false) String region,
            @RequestParam(name="whiskyAge", required = false) Integer whiskyAge
    ) {
        if (region != null){
            return new ResponseEntity<>(distilleryRepository.findByRegion(region), HttpStatus.OK);
        }
        if (whiskyAge != null){
            return new ResponseEntity<>(distilleryRepository.findByWhiskiesYear(whiskyAge), HttpStatus.OK);
        }
        return new ResponseEntity<>(distilleryRepository.findAll(), HttpStatus.OK);
    }


}
