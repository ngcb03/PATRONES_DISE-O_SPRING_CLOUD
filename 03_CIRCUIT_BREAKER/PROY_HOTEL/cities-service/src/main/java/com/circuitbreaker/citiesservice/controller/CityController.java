package com.circuitbreaker.citiesservice.controller;

import com.circuitbreaker.citiesservice.model.City;
import com.circuitbreaker.citiesservice.model.CityDTO;
import com.circuitbreaker.citiesservice.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/cities")
public class CityController {
    @Autowired
    private ICityService service;

    @GetMapping("/")
    public List<City> findCities() {
        return this.service.findCities();
    }

    @GetMapping("/find-with-hotels/{city_id}")
    public CityDTO findCityWithHotels(
            @PathVariable("city_id") Long city_id) {
        return this.service.findCityWithHotels(city_id);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createCity(
            @RequestBody City city) {
        this.service.createCity(city);
        return new ResponseEntity<>(
                "¡The city has been created!",
                HttpStatus.CREATED
        );
    }

}
