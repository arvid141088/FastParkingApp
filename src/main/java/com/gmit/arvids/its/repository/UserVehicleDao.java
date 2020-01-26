package com.gmit.arvids.its.repository;

import com.gmit.arvids.its.repository.entity.UserVehicleEntity;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserVehicleDao {

    @Autowired
    private BaseJdbcTemplate baseJdbcTemplate;

    public List<UserVehicleEntity> getVehicleActiveUsers(Integer vehicleId) {
        Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
            .put("vehicle_id", vehicleId)
            .build();
        String sql = "" +
            "SELECT * FROM user_vehicle " +
            "WHERE vehicle_id = :vehicle_id " +
            "  AND  active = 1";
        return baseJdbcTemplate.queryForList(sql, params, UserVehicleEntity.class);
    }

}
