package com.gmit.arvids.its.repository.entity;

import lombok.Data;


@Data
public class CarParkLocationSlotEntity {

    private Integer id;
    private Integer locationId;
    private Integer index;
    private String name;
    private Boolean available;

}
