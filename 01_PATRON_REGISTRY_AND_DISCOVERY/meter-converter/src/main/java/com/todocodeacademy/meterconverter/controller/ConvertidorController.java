package com.todocodeacademy.meterconverter.controller;

import com.todocodeacademy.meterconverter.service.IConvertidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convertidor")
public class ConvertidorController {

    @Autowired
    private IConvertidorService service;

    @GetMapping("/metros-to-centimetros/{metros}")
    public ResponseEntity<Double> converterMeterToCent(
            @PathVariable("metros") Double metros){
        return new ResponseEntity<>(
                this.service.converterMeterToCent(metros), HttpStatus.OK);
    }

}
