package com.gmit.arvids.its.repository;

import com.gmit.arvids.its.repository.entity.CarParkLocationSlotEntity;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CarParkLocationSlotDao {

    @Autowired
    private BaseJdbcTemplate baseJdbcTemplate;

    public List<CarParkLocationSlotEntity> getCarParSlot(Integer locationId) {
        Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
                .put("location_id", locationId)
                .build();
        return baseJdbcTemplate.queryForList("SELECT * FROM car_park_location_slot WHERE location_id = :location_id", params, CarParkLocationSlotEntity.class);
    }
}
