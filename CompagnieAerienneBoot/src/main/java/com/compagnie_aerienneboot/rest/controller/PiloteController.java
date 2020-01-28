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

import com.compagnie_aerienneboot.rest.dao.PiloteDao;
import com.compagnie_aerienneboot.rest.models.Pilote;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@CrossOrigin("*")
public class PiloteController {
	
	@Autowired
	PiloteDao piloteDao; 
	
	@PostMapping("/pilotes")
	public Pilote createPilote(@Valid @RequestBody Pilote pilote)
	{
		return piloteDao.savePilote(pilote);
	}
	
	@GetMapping("/pilotes")
	public List<Pilote> getAllPilotes()
	{
		return piloteDao.getPilotes();
	}
	
	@GetMapping("/pilotes/{idPil}")
	public ResponseEntity findPiloteById(@PathVariable(name = "idPil") Integer idPil) {
		
		if(idPil== null)
		{
			return ResponseEntity.badRequest().body("Cannot retrieve pilote with null id");
		} else {
//			System.err.println("kejrfjerfhebrhfberfrhebfbrhr==>"+idPil+"!!!!");
			Pilote user;
			try {
				user = piloteDao.piloteItem(idPil);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.notFound().build();//("Cannot retrieve pilote with id="+idPil);
			}
			
//			System.err.println("----hueuger==>"+idPil+"!!!!");
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(user);
		}
	}
	
	@PutMapping("/pilotes")
	public Pilote updatePilote(@Valid @RequestBody Pilote pilote)
	{
		return piloteDao.updatePilote(pilote);
	}
	
	@DeleteMapping("/pilotes/{id}")
	public ResponseEntity<Pilote> deletePilote(@PathVariable(value = "id") Integer idPil) {
		
			Pilote user = piloteDao.piloteItem(idPil);
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			piloteDao.deletePilote(user);
			return ResponseEntity.ok().body(user);
	}
}
