package com.circuitbreaker.citiesservice.service;

import com.circuitbreaker.citiesservice.model.City;
import com.circuitbreaker.citiesservice.model.CityDTO;
import com.circuitbreaker.citiesservice.model.HotelDTO;
import com.circuitbreaker.citiesservice.repository.IHotelApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService {

    @Autowired
    private IHotelApiClient hotelApi;

    private List<City> listCities = new ArrayList<>();

    @Override
    public List<City> findCities() {
        return this.listCities;
    }

    @Override
    public CityDTO findCityWithHotels(Long city_id) {

        // buscamos la ciudad solicitada
        City city = new City();
        for(City cityres: listCities){
            if(cityres.getId_city() == city_id){
                city = cityres;
                break;
            }
        }

        // buscamos los hoteles disponibles en esa ciudad a
        // través de la API hacia el servicio hotels
        List<HotelDTO> listHotels =
                this.hotelApi.findCityWithHotels(city_id);

        // unificamos todos los datos para devolver
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId_city(city.getId_city());
        cityDTO.setNombre(city.getNombre());
        cityDTO.setContinente(city.getContinente());
        cityDTO.setPais(city.getPais());
        cityDTO.setProvincia(city.getProvincia());
        cityDTO.setListHotels(listHotels);

        return cityDTO;
    }

    @Override
    public void createCity(City city) {
        this.listCities.add(city);
    }
}
