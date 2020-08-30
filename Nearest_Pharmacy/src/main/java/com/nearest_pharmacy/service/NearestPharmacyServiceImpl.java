package com.nearest_pharmacy.service;

import com.nearest_pharmacy.model.Address;
import com.nearest_pharmacy.model.Coordinates;
import com.nearest_pharmacy.model.Pharmacy;
import com.nearest_pharmacy.model.PharmacyEntity;
import com.nearest_pharmacy.repository.Pharmacies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.*;

/**
 * Implementation for the {@link NearestPharmacyService}
 */
@Service
public class NearestPharmacyServiceImpl implements NearestPharmacyService {

    @Autowired
    private Pharmacies pharmacies;

    private static double getDistance(double latitude1, double longitude1, double latitude2, double longitude2) {

        // Converting the input latitudes and longitudes from degree to radians
        latitude1 = toRadians(latitude1);
        longitude1 = toRadians(longitude1);

        latitude2 = toRadians(latitude2);
        longitude2 = toRadians(longitude2);

        // Calculate the distance between 2 points
        double distance = pow(sin((latitude2 - latitude1) / 2), 2) + cos(latitude1) * cos(latitude2) * pow(sin((longitude2 - longitude1) / 2), 2);
        
        // Radius of earth in miles is 3956 (for kilometres replace 3956 with 6371)
        double distanceInMiles = (2 * asin(sqrt(distance)))*3956;
       
        return distanceInMiles;
    }

    @Override
    public Pharmacy getNearestPharmacy(final Coordinates coordinates) {

        if (coordinates == null) return null;

        // Get all the pharmacies from the repository
        List<PharmacyEntity> pharmacies = (List) this.pharmacies.findAll();

        Double minimumDistance = Double.MAX_VALUE;
        
        PharmacyEntity nearestPharmacy = null;

        // Looping through all the pharmacies, calculating distance and fining the nearest one.
        for (PharmacyEntity pharmacy : pharmacies) {

            double distance = getDistance(coordinates.getLatitude(), coordinates.getLongitude(), pharmacy.getLatitude(), pharmacy.getLongitude());
            
            /*Finding the nearest pharmacy and the 
             * minimum distance to the pharmacy by iterating through the loop
             */
            if (distance < minimumDistance) {
                nearestPharmacy = pharmacy;
                minimumDistance = distance;
            }
        }

        Address address = new Address();
        Pharmacy pharmacy = new Pharmacy();

        //Creating an object with pharmacy details to return
        address.setAddressLine1(nearestPharmacy.getAddress());
        address.setCity(nearestPharmacy.getCity());
        address.setState(nearestPharmacy.getState());
        address.setZip(nearestPharmacy.getZip());
        
        pharmacy.setName(nearestPharmacy.getName());
        pharmacy.setAddress(address);
        pharmacy.setDistance(minimumDistance);

        return pharmacy;
    }


}
