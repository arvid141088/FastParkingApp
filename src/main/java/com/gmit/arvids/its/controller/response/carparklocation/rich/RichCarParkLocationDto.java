package com.gmit.arvids.its.controller.response.carparklocation.rich;

import com.gmit.arvids.its.domain.CarParkLocation;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class RichCarParkLocationDto {

    private Integer id;
    private String name;
    private String city;
    private String gpsLatitude;
    private String gpsLongitude;
    private List<CarParkLocationSlotDto> slots;

    public static RichCarParkLocationDto from(CarParkLocation carParkLocation) {
        List<CarParkLocationSlotDto> slots = carParkLocation.getCarParkLocationSlots().stream()
                .map(CarParkLocationSlotDto::from)
                .collect(Collectors.toList());

        return RichCarParkLocationDto.builder()
                .id(carParkLocation.getId())
                .name(carParkLocation.getName())
                .city(carParkLocation.getCity())
                .gpsLatitude(carParkLocation.getGpsLatitude())
                .gpsLongitude(carParkLocation.getGpsLongitude())
                .slots(slots)
                .build();
    }

}
