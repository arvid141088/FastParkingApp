package com.gmit.arvids.its.controller;

import com.gmit.arvids.its.controller.request.registercarparkslot.RegisterVehicleCarParkSlotDto;
import com.gmit.arvids.its.service.VehicleCarParkSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    @Autowired
    private VehicleCarParkSlotService vehicleCarParkSlotService;

    @RequestMapping(path = "/car-park-slot/{slotId}", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    public void registerVehicleCarParkSlot(@PathVariable Integer slotId, @RequestBody RegisterVehicleCarParkSlotDto registerVehicleCarParkSlotDto) {
        vehicleCarParkSlotService.registerVehicleCarParkSlot(slotId, registerVehicleCarParkSlotDto.getVehicleRegistration());
    }

    @RequestMapping(path = "/car-park-slot/{slotId}", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.OK)
    public void vehicleLeftCarParkSlot(@PathVariable Integer slotId, @RequestBody RegisterVehicleCarParkSlotDto registerVehicleCarParkSlotDto) {
        vehicleCarParkSlotService.vehicleLeftCarParkSlot(slotId, registerVehicleCarParkSlotDto.getVehicleRegistration());
    }

}
