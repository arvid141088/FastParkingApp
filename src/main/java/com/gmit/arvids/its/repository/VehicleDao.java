package com.gmit.arvids.its.repository;

import com.gmit.arvids.its.repository.entity.VehicleEntity;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class VehicleDao {

    @Autowired
    private BaseJdbcTemplate baseJdbcTemplate;

    public VehicleEntity getVehicleByRegistration(String carRegistration) {

        Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
            .put("car_registration", carRegistration)
            .build();
        return baseJdbcTemplate.queryForObject("SELECT * FROM vehicle WHERE registration = :car_registration", params, VehicleEntity.class);
    }

    public List<VehicleEntity> getAllVehicles(){
        Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
                .build();
        return baseJdbcTemplate.queryForList("SELECT * FROM vehicle", params, VehicleEntity.class);
    }

}
