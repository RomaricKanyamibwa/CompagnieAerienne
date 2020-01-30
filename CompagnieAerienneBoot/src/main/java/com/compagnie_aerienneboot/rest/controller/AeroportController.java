package com.compagnie_aerienneboot.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.compagnie_aerienneboot.rest.dao.AeroportDao;
import com.compagnie_aerienneboot.rest.models.Aeroport;
import com.compagnie_aerienneboot.rest.models.Type;


public class AeroportController {

	@Autowired
	AeroportDao aeroportDao;
	
	@GetMapping("/aeroports")
	public List<Aeroport> getAllAeroports() 
	{
		return aeroportDao.getAeroport();
	}
	
	@PostMapping("/aeroports")
	public Aeroport createAeroport(@Valid @RequestBody Aeroport airport) 
	{
		return aeroportDao.saveAeoroport(airport); // OK
	}
	
	@PutMapping("/aeroports")
	public Aeroport updateAeroport(@Valid @RequestBody Aeroport airport) 
	{
		return aeroportDao.updateAeoroport(airport);
	}
	
	@GetMapping("/types/{IdAeroport}")
	public ResponseEntity findTypeById(@PathVariable(name = "IdAeroport") String IdAeroport) {
		
		if(IdAeroport== null)
		{
			return ResponseEntity.badRequest().body("Cannot retrieve type with null id");
		} else {

			Aeroport user;
			try {
				user = aeroportDao.AeroportItem(IdAeroport);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.notFound().build();//("Cannot retrieve type with id="+idSal);
			}
			
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(user);
		}
	}
}
