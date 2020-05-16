package com.finalyear.models;

import lombok.Data;

@Data
public class CarParkSlotModel {
    private Integer id;
    private Integer locationId;
    private Integer index;
    private String name;
    private Boolean available;
}
