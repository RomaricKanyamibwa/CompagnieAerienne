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

import com.compagnie_aerienneboot.rest.dao.ConstructeurDao;
import com.compagnie_aerienneboot.rest.models.Constructeur;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@CrossOrigin("*")
public class ConstructeurController {
	
	@Autowired
	ConstructeurDao constructeurDao; 
	
	@PostMapping("/constructeurs")
	public Constructeur createConstructeur(@Valid @RequestBody Constructeur constructeur)
	{
		return constructeurDao.saveConstructeur(constructeur);
	}
	
	@GetMapping("/constructeurs")
	public List<Constructeur> getAllConstructeurs()
	{
		return constructeurDao.getConstructeurs();
	}
	
	@GetMapping("/constructeurs/{idCon}")
	public ResponseEntity findConstructeurById(@PathVariable(name = "idCon") Long idCon) {
		
		if(idCon== null)
		{
			return ResponseEntity.badRequest().body("Cannot retrieve constructeur with null id");
		} else {
//			System.err.println("kejrfjerfhebrhfberfrhebfbrhr==>"+idCon+"!!!!");
			Constructeur user;
			try {
				user = constructeurDao.constructeurItem(idCon);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.notFound().build();//("Cannot retrieve constructeur with id="+idCon);
			}
			
//			System.err.println("----hueuger==>"+idCon+"!!!!");
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(user);
		}
	}
	
	@PutMapping("/constructeurs")
	public Constructeur updateConstructeur(@Valid @RequestBody Constructeur constructeur)
	{
		return constructeurDao.updateConstructeur(constructeur);
	}
	
	@DeleteMapping("/constructeurs/{id}")
	public ResponseEntity<Constructeur> deleteConstructeur(@PathVariable(value = "id") Long idCon) {
		
//		if(idCon== null)
//		{
//			return ResponseEntity.badRequest().body("Cannot retrieve constructeur with null id");
//		} else 
//		{
			Constructeur user = constructeurDao.constructeurItem(idCon);
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			constructeurDao.deleteConstructeur(user);
			return ResponseEntity.ok().body(user);
//		}
	}
}
