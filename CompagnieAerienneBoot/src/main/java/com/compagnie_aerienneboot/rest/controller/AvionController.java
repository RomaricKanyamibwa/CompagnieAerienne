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

import com.compagnie_aerienneboot.rest.dao.AvionDao;
import com.compagnie_aerienneboot.rest.models.Avion;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@CrossOrigin("*")
public class AvionController {
	
	@Autowired
	AvionDao avionDao; 
	
	@PostMapping("/avions")
	public Avion createAvion(@Valid @RequestBody Avion avion)
	{
		return avionDao.saveAvion(avion);
	}
	
	@GetMapping("/avions")
	public List<Avion> getAllAvions()
	{
		return avionDao.getAvions();
	}
	
	@GetMapping("/avions/{idAvion}")
	public ResponseEntity findAvionById(@PathVariable(name = "idAvion") Long idAvion) {
		
		if(idAvion== null)
		{
			return ResponseEntity.badRequest().body("Cannot retrieve avion with null id");
		} else {
//			System.err.println("kejrfjerfhebrhfberfrhebfbrhr==>"+idAvion+"!!!!");
			Avion user;
			try {
				user = avionDao.getItem(idAvion);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.notFound().build();//("Cannot retrieve avion with id="+idAvion);
			}
			
//			System.err.println("----hueuger==>"+idAvion+"!!!!");
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(user);
		}
	}
	
	@PutMapping("/avions")
	public Avion updateAvion(@Valid @RequestBody Avion avion)
	{
		return avionDao.updateAvion(avion);
	}
	
	@DeleteMapping("/avions/{id}")
	public ResponseEntity<Avion> deleteAvion(@PathVariable(value = "id") Long idAvion) {
		
//		if(idAvion== null)
//		{
//			return ResponseAvionntity.badRequest().body("Cannot retrieve avion with null id");
//		} else 
//		{
			Avion user = avionDao.getItem(idAvion);
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			avionDao.deleteAvion(user);
			return ResponseEntity.ok().body(user);
//		}
	}
}
