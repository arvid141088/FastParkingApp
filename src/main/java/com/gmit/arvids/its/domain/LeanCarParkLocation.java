package com.gmit.arvids.its.domain;

import com.gmit.arvids.its.repository.entity.CarParkLocationEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LeanCarParkLocation {

    private Integer id;
    private String name;
    private String city;
    private String gpsLatitude;
    private String gpsLongitude;

    public static LeanCarParkLocation from(CarParkLocationEntity carParkLocationEntity) {
        return LeanCarParkLocation.builder()
                .id(carParkLocationEntity.getId())
                .name(carParkLocationEntity.getName())
                .city(carParkLocationEntity.getCity())
                .gpsLatitude(carParkLocationEntity.getGpsLatitude())
                .gpsLongitude(carParkLocationEntity.getGpsLongitude())
                .build();
    }
}
