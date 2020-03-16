package com.gmit.arvids.its.domain;

import com.gmit.arvids.its.repository.entity.VehicleEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LeanVehicleDetails {
    private Integer id;
    private String make;
    private String model;
    private String registration;

    public static LeanVehicleDetails from(VehicleEntity vehicleEntity){

        return  LeanVehicleDetails.builder()
                .id(vehicleEntity.getId())
                .registration(vehicleEntity.getRegistration())
                .make(vehicleEntity.getMake())
                .model(vehicleEntity.getModel())
                .build();
    }

}
