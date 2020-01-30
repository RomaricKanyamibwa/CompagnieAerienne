package com.compagnie_aerienneboot.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.compagnie_aerienneboot.rest.dao.AffectationDao;
import com.compagnie_aerienneboot.rest.models.Affectation;
import com.compagnie_aerienneboot.rest.models.PK_KeyAffectation;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@CrossOrigin("*")
public class AffectationController {
	
	@Autowired
	AffectationDao affectationDao; 
	
	@PostMapping("/affectations")
	public Affectation createAffectation(@Valid @RequestBody Affectation affectation)
	{
		return affectationDao.saveAffectation(affectation);
	}
	
	@GetMapping("/affectations")
	public List<Affectation> getAllAffectations()
	{
		return affectationDao.getAffectations();
	}
	
	@GetMapping("/affectations/{idTyp}")
	public ResponseEntity findAffectationById(@PathVariable(name = "idTyp") PK_KeyAffectation idTyp) {
		
		if(idTyp== null)
		{
			return ResponseEntity.badRequest().body("Cannot retrieve affectation with null id");
		} else {
			Affectation user;
			try {
				user = affectationDao.affItem(idTyp);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.notFound().build();
			}
			
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(user);
		}
	}
	
	@PutMapping("/affectations")
	public Affectation updateAffectation(@Valid @RequestBody Affectation affectation)
	{
		return affectationDao.updateAffectation(affectation);
	}
	
	@DeleteMapping("/affectations/{id}")
	public ResponseEntity<Affectation> deleteAffectation(@PathVariable(value = "id") PK_KeyAffectation idAffectation) {

			Affectation user = affectationDao.affItem(idAffectation);
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			affectationDao.deleteAffectation(user);
			return ResponseEntity.ok().body(user);
	}
}
