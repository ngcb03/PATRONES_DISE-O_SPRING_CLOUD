package com.circuitbreaker.citiesservice.model;

import lombok.Data;

@Data
public class City {

    private Long id_city;
    private String nombre;
    private String continente;
    private String pais;
    private String provincia;

}
