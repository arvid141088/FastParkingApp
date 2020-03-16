package com.gmit.arvids.its.service;

import com.gmit.arvids.its.repository.AvailabilityDao;
import com.gmit.arvids.its.repository.CarParkLocationDao;
import com.gmit.arvids.its.repository.CarParkLocationSlotBookingDao;
import com.gmit.arvids.its.repository.CarParkLocationSlotDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AvailabilityService {
    @Autowired
    private AvailabilityDao availabilityDao;
    @Autowired
    CarParkLocationSlotDao carParkLocationSlotDao;
    @Autowired
    private CarParkLocationSlotBookingDao carParkLocationSlotBookingDao;
    @Autowired
    private CarParkLocationDao carParkLocationDao;


    /**
     * Data from RaspPi to update slot availability
     */
    @Transactional
    public void updateAvailability(Integer id, String locationId) {

//            CarParkLocationSlotEntity carParkLocationSlotEntity = availabilityDao.getLocationId(locationId);
//            //Get(Create) list of location ID's
//            List<CarParkLocationSlotEntity> locations = AvailabilityDao.getLocationId();
//            CarParkLocationSlotEntity slot = carParkLocationSlotDao.getCarParSlot(id);
//
//            //Iterate through each element in the List
//            locations.forEach(location -> {
//
//                CarParkLocationSlotEntity carParkLocationSlotEntity = new CarParkLocationEntity();
//                carParkLocationEntity.setSlotId(slot.getId());
//                carParkSlotBookingEntity.setLocationId(slot.getLocationId());
//                carParkSlotBookingEntity.setUserId(user.getUserId());
//                carParkSlotBookingEntity.setVehicleId(user.getVehicleId());
//                carParkSlotBookingEntity.setStart(LocalDateTime.now());
//
//                carParkLocationSlotBookingDao.insertCarParkBooking(carParkSlotBookingEntity);
//                carParkLocationSlotDao.updateAvailability(slot.getId(), false);
//
//            });

    }
}
