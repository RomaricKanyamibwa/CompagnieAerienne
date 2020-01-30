package com.compagnie_aerienneboot.rest.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compagnie_aerienneboot.rest.models.Affectation;
import com.compagnie_aerienneboot.rest.models.PK_KeyAffectation;
import com.compagnie_aerienneboot.rest.repository.AffectationRepository;


@Service
public class AffectationDao {
	
	@Autowired
	AffectationRepository affRepository;
	
	public List<Affectation> getAffectations(){
		return affRepository.findAll();
	}
	
	public Affectation saveAffectation(Affectation aff)
	{
		return affRepository.save(aff);
	}
	
	public Affectation getAffectation(PK_KeyAffectation id) {
		return affRepository.getOne(id);
	}

	public Affectation updateAffectation(@Valid Affectation aff) {
		// TODO Auto-generated method stub
		return affRepository.saveAndFlush(aff);
	}

	public void deleteAffectation(Affectation aff) {
		affRepository.delete(aff);
		
	}

	public Affectation affItem(PK_KeyAffectation idAffectation) {
		// TODO Auto-generated method stub
		return affRepository.findById(idAffectation).get();
	}
	
	public List<Affectation> saveAll(List<Affectation>affs){
		return affRepository.saveAll(affs);
	}
	
}
