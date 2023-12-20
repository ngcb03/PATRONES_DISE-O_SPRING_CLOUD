package com.circuitbreaker.hotelsservice.model;

import lombok.Data;

@Data
public class Hotel {

    private Long hotel_id;
    private Long city_id;
    private String nombre;
    private String continente;
    private String pais;
    private String provedencia;

}
