package com.circuitbreaker.citiesservice.model;

import lombok.Data;

@Data
public class HotelDTO {

    private Long hotel_id;
    private Long city_id;
    private String nombre;
    private String continente;
    private String pais;
    private String provedencia;

}
