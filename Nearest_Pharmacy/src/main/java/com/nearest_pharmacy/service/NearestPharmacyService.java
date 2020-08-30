package com.nearest_pharmacy.service;

import com.nearest_pharmacy.controller.PharmacyController;
import com.nearest_pharmacy.model.Coordinates;
import com.nearest_pharmacy.model.Pharmacy;

/**
 * NearestPharmacyService interacts with te {@link PharmacyController}
 */
public interface NearestPharmacyService {
    /**
     * Takes the coordinates of te current location and returns the nearest pharmacy based on the distance.
     *
     * @param coordinates contains latitude and longitude {@link Coordinates}
     * @returns {@link Pharmacy} with all the details of the closest/nearest pharmacy
     */
    Pharmacy getNearestPharmacy(Coordinates coordinates);
}
