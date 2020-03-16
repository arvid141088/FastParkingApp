package com.gmit.arvids.its.controller.request.PiController;


import com.gmit.arvids.its.service.AvailabilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AvailabilityController {
    @Autowired
    private AvailabilityService availabilityService;

    @RequestMapping(path = "/update-availability/{slotId}", method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    public void updateSlotAvailability(@PathVariable Integer slotId, @RequestBody AvailabilityDto availabilityDto) {

    }
}
