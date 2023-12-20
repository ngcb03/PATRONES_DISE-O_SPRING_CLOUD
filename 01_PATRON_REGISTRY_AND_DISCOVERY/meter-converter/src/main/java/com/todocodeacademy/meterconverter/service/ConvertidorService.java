package com.todocodeacademy.meterconverter.service;

import org.springframework.stereotype.Service;

@Service
public class ConvertidorService implements IConvertidorService {

    @Override
    public Double converterMeterToCent(Double metros) {
        return (metros * 100);
    }

}
