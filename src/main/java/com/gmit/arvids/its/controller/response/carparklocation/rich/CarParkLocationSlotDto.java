package com.gmit.arvids.its.controller.response.carparklocation.rich;

import com.gmit.arvids.its.domain.LeanCarParkLocationSlot;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarParkLocationSlotDto {

    private Integer id;
    private Integer index;
    private Boolean available;

    public static CarParkLocationSlotDto from(LeanCarParkLocationSlot leanCarParkLocationSlot) {
        return CarParkLocationSlotDto.builder()
                .id(leanCarParkLocationSlot.getId())
                .index(leanCarParkLocationSlot.getIndex())
                .available(leanCarParkLocationSlot.getAvailable())
                .build();
    }

}
