package com.circuitbreaker.citiesservice.model;

import lombok.Data;

import java.util.List;

@Data
public class CityDTO {

    private Long id_city;
    private String nombre;
    private String continente;
    private String pais;
    private String provincia;
    private List<HotelDTO> listHotels;

}
