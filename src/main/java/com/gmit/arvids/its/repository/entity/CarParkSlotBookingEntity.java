package com.gmit.arvids.its.repository.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CarParkSlotBookingEntity {

    private Integer id;
    private Integer slotId;
    private Integer locationId;
    private Integer userId;
    private Integer vehicleId;
    private LocalDateTime start;
    private LocalDateTime end;

}
