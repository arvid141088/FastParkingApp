package com.gmit.arvids.its.controller;

import com.gmit.arvids.its.controller.request.registercarparkslot.RegisterVehicleCarParkSlotDto;
import com.gmit.arvids.its.service.VehicleCarParkSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * This controller is registering car park slots availability
 * for user bookings and Results from Raspberry Pi
 */
@RestController
public class VehicleController {

    @Autowired
    private VehicleCarParkSlotService vehicleCarParkSlotService;

    /**
     *Vehicle is getting registered at car park
     */
    @RequestMapping(path = "/car-park-slot/{slotId}", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    public void registerVehicleCarParkSlot(@PathVariable Integer slotId, @RequestBody RegisterVehicleCarParkSlotDto registerVehicleCarParkSlotDto) {
        vehicleCarParkSlotService.registerVehicleCarParkSlot(slotId, registerVehicleCarParkSlotDto.getVehicleRegistration());
    }

    /**
     *Vehicle is leaving car park
     */
    @RequestMapping(path = "/car-park-slot/{slotId}", method = RequestMethod.PUT)
    @ResponseStatus(code = HttpStatus.OK)
    public void vehicleLeftCarParkSlot(@PathVariable Integer slotId, @RequestBody RegisterVehicleCarParkSlotDto registerVehicleCarParkSlotDto) {
        vehicleCarParkSlotService.vehicleLeftCarParkSlot(slotId, registerVehicleCarParkSlotDto.getVehicleRegistration());
    }

    /**
     * Pi is registering slot availability
     * @param slotId is an ID which determines request.
     */
    @RequestMapping(path = "/car-park-slot-busy/{slotId}", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    public void piRegisterSlotBusy(@PathVariable Integer slotId) {
        vehicleCarParkSlotService.piRegisterSlotBusy(slotId);
    }

    @RequestMapping(path = "/car-park-slot-free/{slotId}", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    public void piRegisterSlotFree(@PathVariable Integer slotId) {
        vehicleCarParkSlotService.piRegisterSlotFree(slotId);
    }










}
