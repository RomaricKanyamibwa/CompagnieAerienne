package com.compagnie_aerienneboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compagnie_aerienneboot.rest.models.Pilote;

//@Repository
public interface PiloteRepository extends JpaRepository<Pilote, Integer> {
}
