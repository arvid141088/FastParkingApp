package com.gmit.arvids.its.repository;

import com.gmit.arvids.its.repository.entity.CarParkLocationSlotEntity;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AvailabilityDao {
    @Autowired
    private BaseJdbcTemplate baseJdbcTemplate;

    public int updateSlotAvailability(Integer slotId, Boolean available) {

        Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
                .put("slot_id", slotId)
                .put("available", available)
                .build();
        String sql = "" +
                "UPDATE car_park_location_slot SET " +
                "    available = :available " +
                " WHERE " +
                "    id = :slot_id ";

        return baseJdbcTemplate.update(sql, params);
    }

    /**
     * This method will allow to show specific location ID
     */
    public CarParkLocationSlotEntity getLocationId (String locationId){
    Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
            .put("location_id", locationId)
            .build();
        return baseJdbcTemplate.queryForObject("SELECT * FROM car_park_location_slot WHERE location_id = :location_id", params, CarParkLocationSlotEntity .class);
    }

}
