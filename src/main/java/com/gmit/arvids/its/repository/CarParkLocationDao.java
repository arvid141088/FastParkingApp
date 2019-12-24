package com.gmit.arvids.its.repository;

import com.gmit.arvids.its.repository.entity.CarParkLocationEntity;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyMap;

@Repository
public class CarParkLocationDao {

    @Autowired
    private BaseJdbcTemplate baseJdbcTemplate;

    public List<CarParkLocationEntity> getCarParkLocations() {
        return baseJdbcTemplate.queryForList("SELECT * FROM car_park_location", emptyMap(), CarParkLocationEntity.class);
    }

    public CarParkLocationEntity getCarParkLocation(Integer locationId) {
        Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
                .put("id", locationId)
                .build();
        return baseJdbcTemplate.queryForObject("SELECT * FROM car_park_location WHERE id = :id", params, CarParkLocationEntity.class);
    }
}
