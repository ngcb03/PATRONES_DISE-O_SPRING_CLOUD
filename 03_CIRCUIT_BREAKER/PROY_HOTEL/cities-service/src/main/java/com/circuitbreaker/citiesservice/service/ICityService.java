package com.circuitbreaker.citiesservice.service;

import com.circuitbreaker.citiesservice.model.City;
import com.circuitbreaker.citiesservice.model.CityDTO;

import java.util.List;

public interface ICityService {

    public List<City> findCities();
    public CityDTO findCityWithHotels(Long city_id);
    public void createCity(City city);

}
