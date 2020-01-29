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

import com.compagnie_aerienneboot.rest.dao.VolDao;
import com.compagnie_aerienneboot.rest.models.Vol;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@CrossOrigin("*")
public class VolController {
	
	@Autowired
	VolDao volDao; 
	
	@PostMapping("/vols")
	public Vol createVol(@Valid @RequestBody Vol vol)
	{
		return volDao.saveVol(vol);
	}
	
	@GetMapping("/vols")
	public List<Vol> getAllVols()
	{
		return volDao.getVols();
	}
	
	@GetMapping("/vols/{idTyp}")
	public ResponseEntity findVolById(@PathVariable(name = "idTyp") String idTyp) {
		
		if(idTyp== null)
		{
			return ResponseEntity.badRequest().body("Cannot retrieve vol with null id");
		} else {
			Vol user;
			try {
				user = volDao.volItem(idTyp);
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
	
	@PutMapping("/vols")
	public Vol updateVol(@Valid @RequestBody Vol vol)
	{
		return volDao.updateVol(vol);
	}
	
	@DeleteMapping("/vols/{id}")
	public ResponseEntity<Vol> deleteVol(@PathVariable(value = "id") String idVol) {

			Vol user = volDao.volItem(idVol);
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			volDao.deleteVol(user);
			return ResponseEntity.ok().body(user);
	}
}
