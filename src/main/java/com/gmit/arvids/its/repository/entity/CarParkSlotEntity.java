package com.gmit.arvids.its.repository.entity;

import lombok.Data;

import java.time.LocalTime;

@Data
public class CarParkSlotEntity {

    private Integer slotId;
    private Integer locationId;
    private Boolean isFree;
    private LocalTime isBooked;
    private String carReg;

}
