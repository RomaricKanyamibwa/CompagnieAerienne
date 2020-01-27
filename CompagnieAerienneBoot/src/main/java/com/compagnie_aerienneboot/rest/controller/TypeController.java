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
import org.springframework.web.bind.annotation.RequestMethod;

import com.compagnie_aerienneboot.rest.dao.TypeDao;
import com.compagnie_aerienneboot.rest.models.Type;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
@CrossOrigin("*")
public class TypeController {
	
	@Autowired
	TypeDao typeDao; 
	
	@PostMapping("/types")
	public Type createType(@Valid @RequestBody Type type)
	{
		return typeDao.saveType(type);
	}
	
	@GetMapping("/types")
	public List<Type> getAllTypes()
	{
		return typeDao.getTypes();
	}
	
	@GetMapping("/types/{idSal}")
	public ResponseEntity findTypeById(@PathVariable(name = "idSal") Long idSal) {
		
		if(idSal== null)
		{
			return ResponseEntity.badRequest().body("Cannot retrieve type with null id");
		} else {
//			System.err.println("kejrfjerfhebrhfberfrhebfbrhr==>"+idSal+"!!!!");
			Type user;
			try {
				user = typeDao.typeItem(idSal);
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.notFound().build();//("Cannot retrieve type with id="+idSal);
			}
			
//			System.err.println("----hueuger==>"+idSal+"!!!!");
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok().body(user);
		}
	}
	
	@PutMapping("/types")
	public Type updateType(@Valid @RequestBody Type type)
	{
		return typeDao.updateType(type);
	}
	
	@DeleteMapping("/types/{id}")
	public ResponseEntity<Type> deleteType(@PathVariable(value = "id") Long idSal) {
		
//		if(idSal== null)
//		{
//			return ResponseEntity.badRequest().body("Cannot retrieve type with null id");
//		} else 
//		{
			Type user = typeDao.typeItem(idSal);
			if(user==null)
			{
				return ResponseEntity.notFound().build();
			}
			typeDao.deleteType(user);
			return ResponseEntity.ok().body(user);
//		}
	}
}
