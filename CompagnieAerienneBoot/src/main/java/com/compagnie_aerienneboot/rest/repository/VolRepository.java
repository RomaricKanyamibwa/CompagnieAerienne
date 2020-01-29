package com.compagnie_aerienneboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compagnie_aerienneboot.rest.models.Type;
import com.compagnie_aerienneboot.rest.models.Vol;

//@Repository
public interface VolRepository extends JpaRepository<Vol, String> {
}
