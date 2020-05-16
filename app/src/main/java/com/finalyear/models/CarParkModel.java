package com.finalyear.models;


import lombok.Data;

@Data
public class CarParkModel {

    private Integer id;
    private String name;
    private String city;
    private String gpsLatitude;
    private String gpsLongitude;

}
