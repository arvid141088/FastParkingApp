package com.gmit.arvids.its.controller;

import com.gmit.arvids.its.controller.response.carparklocation.CarParkLocationDto;
import com.gmit.arvids.its.controller.response.carparklocation.rich.RichCarParkLocationDto;
import com.gmit.arvids.its.domain.CarParkLocation;
import com.gmit.arvids.its.domain.LeanCarParkLocation;
import com.gmit.arvids.its.service.CarParkLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CarParkLocationController {


    @Autowired
    private CarParkLocationService carParkLocationService;


    /**
     * Endpoint which returns Full list of car parks
     */
    @RequestMapping(path = "/car-park-locations", method = RequestMethod.GET)
    public List<CarParkLocationDto> getCarParkLocations() {
        List<LeanCarParkLocation>  carParkLocations = carParkLocationService.getCarParkLocations();
        return carParkLocations.stream()
                .map(CarParkLocationDto::from)
                .collect(Collectors.toList());
    }


    /**
     * Endpoint which returns detailed info about specific Location
     * @param locationId  is an ID which determines the request. eg location 4
     *
     */
    @RequestMapping(path = "/car-park-locations/{locationId}", method = RequestMethod.GET)
    public RichCarParkLocationDto getCarParkLocationById(@PathVariable Integer locationId) {
        CarParkLocation carParkLocation = carParkLocationService.getCarParkLocation(locationId);
        return RichCarParkLocationDto.from(carParkLocation);
    }

}
