package com.nearest_pharmacy.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This model maps to a single row in the pharmacies database
 */
@Entity
@Table(name = "pharmacydetails")
public class PharmacyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zip")
    private String zip;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		final PharmacyEntity that = (PharmacyEntity) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(name, that.name) &&
				Objects.equals(address, that.address) &&
				Objects.equals(city, that.city) &&
				Objects.equals(state, that.state) &&
				Objects.equals(zip, that.zip) &&
				Objects.equals(latitude, that.latitude) &&
				Objects.equals(longitude, that.longitude);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, address, city, state, zip, latitude, longitude);
	}
}
