package com.compagnie_aerienneboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compagnie_aerienneboot.rest.models.Aeroport;

@Repository
public interface AeroportRepository extends JpaRepository<Aeroport, String>  {
}
