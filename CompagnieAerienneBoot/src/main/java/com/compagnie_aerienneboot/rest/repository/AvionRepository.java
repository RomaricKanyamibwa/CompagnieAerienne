package com.compagnie_aerienneboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compagnie_aerienneboot.rest.models.Avion;

@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {
}
