package com.gmit.arvids.its.domain;

import com.gmit.arvids.its.repository.entity.CarParkLocationEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CarParkLocation {

    private Integer id;
    private String name;
    private String city;
    private String gpsLatitude;
    private String gpsLongitude;
    private List<LeanCarParkLocationSlot> carParkLocationSlots;

    public static CarParkLocation from(CarParkLocationEntity carParkLocationEntity, List<LeanCarParkLocationSlot> carParkLocationSlots) {
        return CarParkLocation.builder()
                .id(carParkLocationEntity.getId())
                .name(carParkLocationEntity.getName())
                .city(carParkLocationEntity.getCity())
                .gpsLatitude(carParkLocationEntity.getGpsLatitude())
                .gpsLongitude(carParkLocationEntity.getGpsLongitude())
                .carParkLocationSlots(carParkLocationSlots)
                .build();
    }
}
