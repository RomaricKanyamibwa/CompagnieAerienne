package com.compagnie_aerienneboot.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.compagnie_aerienneboot.rest.models.Affectation;
import com.compagnie_aerienneboot.rest.models.PK_KeyAffectation;

//@Repository
public interface AffectationRepository extends JpaRepository<Affectation, PK_KeyAffectation> {
}
