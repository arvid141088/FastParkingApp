package com.gmit.arvids.its.repository;

import com.gmit.arvids.its.repository.entity.CarParkSlotBookingEntity;
import com.google.common.collect.ImmutableMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class CarParkLocationSlotBookingDao {

    @Autowired
    private BaseJdbcTemplate baseJdbcTemplate;

    public Integer insertCarParkBooking(CarParkSlotBookingEntity carParkSlotBookingEntity) {
        Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
            .put("slot_id", carParkSlotBookingEntity.getSlotId())
            .put("location_id", carParkSlotBookingEntity.getLocationId())
            .put("user_id", carParkSlotBookingEntity.getUserId())
            .put("vehicle_id", carParkSlotBookingEntity.getVehicleId())
            .put("start_date_time", carParkSlotBookingEntity.getStart())
            .build();
        String sql = "" +
            "INSERT INTO car_park_slot_booking " +
            "    (slot_id, location_id, user_id, vehicle_id, start_date_time) " +
            " VALUES " +
            "    (:slot_id, :location_id, :user_id, :vehicle_id, :start_date_time)";

        return baseJdbcTemplate.insert(sql, params);
    }

    public Integer updateCarParkBookingEndTime(CarParkSlotBookingEntity carParkSlotBookingEntity) {
        Map<String, Object> params = new ImmutableMap.Builder<String, Object>()
            .put("slot_id", carParkSlotBookingEntity.getSlotId())
            .put("location_id", carParkSlotBookingEntity.getLocationId())
            .put("user_id", carParkSlotBookingEntity.getUserId())
            .put("vehicle_id", carParkSlotBookingEntity.getVehicleId())
            .put("end_date_time", carParkSlotBookingEntity.getEnd())
            .build();
        String sql = "" +
            "UPDATE car_park_slot_booking SET " +
            "    end_date_time = :end_date_time " +
            " WHERE " +
            "    slot_id = :slot_id AND location_id = :location_id "  +
            "      AND user_id = :user_id AND vehicle_id = :vehicle_id " +
            "      AND end_date_time IS NULL ";

        return baseJdbcTemplate.insert(sql, params);
    }

}
