package com.gmit.arvids.its.repository.entity;

import lombok.Data;

@Data
public class CarParkLocationEntity {

    private Integer id;
    private String name;
    private String city;
    private String gpsLatitude;
    private String gpsLongitude;

}
