package com.gmit.arvids.its.service;

import com.gmit.arvids.its.repository.*;
import com.gmit.arvids.its.repository.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VehicleCarParkSlotService {

    @Autowired
    private VehicleDao vehicleDao;
    @Autowired
    private UserVehicleDao userVehicleDao;
    @Autowired
    private CarParkLocationSlotDao carParkLocationSlotDao;
    @Autowired
    private CarParkLocationSlotBookingDao carParkLocationSlotBookingDao;
    @Autowired
    CarParkLocationDao carParkLocationDao;

    /**
     * Booking car park slot
     */
    @Transactional
    public void registerVehicleCarParkSlot(Integer slotId, String vehicleRegistration) {
        VehicleEntity vehicleEntity = vehicleDao.getVehicleByRegistration(vehicleRegistration);
        List<UserVehicleEntity> users = userVehicleDao.getVehicleActiveUsers(vehicleEntity.getId());
        CarParkLocationSlotEntity slot = carParkLocationSlotDao.getCarParSlot(slotId);
        //CarParkLocationEntity location = carParkLocationDao.getCarParkLocation(locationId);
        if (Boolean.FALSE.equals(slot.getAvailable())) {
            throw new RuntimeException("Car park slot is busy");
        }

        users.forEach(user -> {

            CarParkSlotBookingEntity carParkSlotBookingEntity = new CarParkSlotBookingEntity();
            carParkSlotBookingEntity.setSlotId(slot.getId());
            carParkSlotBookingEntity.setLocationId(slot.getLocationId());
            carParkSlotBookingEntity.setUserId(user.getUserId());
            carParkSlotBookingEntity.setVehicleId(user.getVehicleId());
            carParkSlotBookingEntity.setStart(LocalDateTime.now());

            carParkLocationSlotBookingDao.insertCarParkBooking(carParkSlotBookingEntity);
            carParkLocationSlotDao.updateAvailability(slot.getId(), false);

        });
    }

    @Transactional
    public void vehicleLeftCarParkSlot(Integer slotId, String vehicleRegistration) {
        VehicleEntity vehicleEntity = vehicleDao.getVehicleByRegistration(vehicleRegistration);
        List<UserVehicleEntity> users = userVehicleDao.getVehicleActiveUsers(vehicleEntity.getId());
        CarParkLocationSlotEntity slot = carParkLocationSlotDao.getCarParSlot(slotId);

        users.forEach(user -> {

            CarParkSlotBookingEntity carParkSlotBookingEntity = new CarParkSlotBookingEntity();
            carParkSlotBookingEntity.setSlotId(slot.getId());
            carParkSlotBookingEntity.setLocationId(slot.getLocationId());
            carParkSlotBookingEntity.setUserId(user.getUserId());
            carParkSlotBookingEntity.setVehicleId(user.getVehicleId());
            carParkSlotBookingEntity.setEnd(LocalDateTime.now());

            carParkLocationSlotBookingDao.updateCarParkBookingEndTime(carParkSlotBookingEntity);
            carParkLocationSlotDao.updateAvailability(slot.getId(), true);
        });
    }


    /**
     * Registering slot availability from RPi
     */
    @Transactional
    public void piRegisterSlotBusy(Integer slotId) {
        CarParkLocationSlotEntity slot = carParkLocationSlotDao.getCarParSlot(slotId);
        carParkLocationSlotDao.updateAvailability(slot.getId(), false);

    }
    @Transactional
    public void piRegisterSlotFree(Integer slotId) {
        CarParkLocationSlotEntity slot = carParkLocationSlotDao.getCarParSlot(slotId);
        carParkLocationSlotDao.updateAvailability(slot.getId(), true);

    }
}
