package com.gmit.arvids.its.controller.response.carparklocation;

import com.gmit.arvids.its.domain.LeanCarParkLocation;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarParkLocationDto {

    private Integer id;
    private String name;
    private String city;
    private String gpsLatitude;
    private String gpsLongitude;

    public static CarParkLocationDto from(LeanCarParkLocation leanCarParkLocation) {
        return CarParkLocationDto.builder()
                .id(leanCarParkLocation.getId())
                .name(leanCarParkLocation.getName())
                .city(leanCarParkLocation.getCity())
                .gpsLatitude(leanCarParkLocation.getGpsLatitude())
                .gpsLongitude(leanCarParkLocation.getGpsLongitude())
                .build();
    }
}
