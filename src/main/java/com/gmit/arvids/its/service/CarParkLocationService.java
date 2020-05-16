package com.gmit.arvids.its.service;

import com.gmit.arvids.its.domain.CarParkLocation;
import com.gmit.arvids.its.domain.LeanCarParkLocation;
import com.gmit.arvids.its.domain.LeanCarParkLocationSlot;
import com.gmit.arvids.its.repository.CarParkLocationDao;
import com.gmit.arvids.its.repository.CarParkLocationSlotDao;
import com.gmit.arvids.its.repository.entity.CarParkLocationEntity;
import com.gmit.arvids.its.repository.entity.CarParkLocationSlotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarParkLocationService {

    @Autowired
    private CarParkLocationDao carParkLocationDao;
    @Autowired
    private CarParkLocationSlotDao carParkLocationSlotDao;

    /**
     * Getting information about all locations
     */
    public List<LeanCarParkLocation> getCarParkLocations() {
        List<CarParkLocationEntity> carParkLocationEntities = carParkLocationDao.getCarParkLocations();
        return carParkLocationEntities.stream()
                .map(LeanCarParkLocation::from)
                .collect(Collectors.toList());
    }

    /**
     * Getting information about specific location
     */
    public CarParkLocation getCarParkLocation(Integer locationId) {
        List<CarParkLocationSlotEntity> carParkLocationSlotEntities = carParkLocationSlotDao.getCarParSlots(locationId);
        List<LeanCarParkLocationSlot> carParkLocationSlots = carParkLocationSlotEntities.stream()
                .map(LeanCarParkLocationSlot::from)
                .collect(Collectors.toList());

        CarParkLocationEntity carParkLocationEntity = carParkLocationDao.getCarParkLocation(locationId);
        return CarParkLocation.from(carParkLocationEntity, carParkLocationSlots);
    }
}
