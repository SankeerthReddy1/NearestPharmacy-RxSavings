package com.nearest_pharmacy.repository;

import com.nearest_pharmacy.model.PharmacyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Pharmacies extends CrudRepository<PharmacyEntity, Integer> {
}
