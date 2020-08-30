package com.nearest_pharmacy.model;

import java.util.Objects;

/**
 * This model contains the details of a individual pharmacy.
 */
public class Pharmacy {

    private String name;
    private Address address;
    private Double distance;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(final Double distance) {
        this.distance = distance;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Pharmacy pharmacy = (Pharmacy) o;
        return Objects.equals(name, pharmacy.name) &&
                Objects.equals(address, pharmacy.address) &&
                Objects.equals(distance, pharmacy.distance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, distance);
    }
}
