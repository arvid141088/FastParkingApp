package com.gmit.arvids.its.domain;

import com.gmit.arvids.its.repository.entity.CarParkLocationSlotEntity;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LeanCarParkLocationSlot {

    private Integer id;
    private Integer locationId;
    private Integer index;
    private String name;
    private Boolean available;

    public static LeanCarParkLocationSlot from(CarParkLocationSlotEntity carParkLocationSlotEntity) {
        return LeanCarParkLocationSlot.builder()
                .id(carParkLocationSlotEntity.getId())
                .locationId(carParkLocationSlotEntity.getLocationId())
                .index(carParkLocationSlotEntity.getIndex())
                .name(carParkLocationSlotEntity.getName())
                .available(carParkLocationSlotEntity.getAvailable())
                .build();
    }

}
