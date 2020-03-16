package com.gmit.arvids.its.repository.entity;

import lombok.Data;


@Data
public class CarParkLocationSlotEntity {

    /**
     * Direct links to Database info
     */
    private Integer id;
    private Integer locationId;
    private Integer index;
    private String name;
    private Boolean available;

}
