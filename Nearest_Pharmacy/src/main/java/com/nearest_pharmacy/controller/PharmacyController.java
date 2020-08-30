package com.nearest_pharmacy.controller;

import com.nearest_pharmacy.model.Coordinates;
import com.nearest_pharmacy.model.Pharmacy;
import com.nearest_pharmacy.service.NearestPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This Controller is responsible for handling the HTTP requests for the pharmacy.
 */
@RestController
@RequestMapping(value = "/pharmacy")
public class PharmacyController {

    @Autowired
    private NearestPharmacyService service;

    /**
     * Takes the current location through {@link Coordinates} and returns the nearest pharmacy based
     * on distance
     *
     * @param coordinates {@link Coordinates} with latitude and longitude details.
     * @returns {@link Pharmacy} object with pharmacy details and distance
     */
    @GetMapping("/nearest")
    public Pharmacy getNearestPharmacy(@RequestBody final Coordinates coordinates){

        return service.getNearestPharmacy(coordinates);

    }
}
