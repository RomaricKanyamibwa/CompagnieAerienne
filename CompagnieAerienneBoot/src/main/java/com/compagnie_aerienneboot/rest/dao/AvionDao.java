package com.compagnie_aerienneboot.rest.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compagnie_aerienneboot.rest.models.Avion;
import com.compagnie_aerienneboot.rest.repository.AvionRepository;

@Service
public class AvionDao
{
	@Autowired
	AvionRepository genRepository;
	
	public AvionRepository getGenRepository() {
		return genRepository;
	}

	public void setGenRepository(AvionRepository genRepository) {
		this.genRepository = genRepository;
	}

	public List<Avion> getAvions(){
		return genRepository.findAll();
	}
	
	public Avion saveAvion(Avion type)
	{
		return genRepository.save(type);
	}
	
	public Avion getAvion(Long id) {
		return genRepository.getOne(id);
	}

	public Avion updateAvion(@Valid Avion type) {
		// TODO Auto-generated method stub
		return genRepository.saveAndFlush(type);
	}

	public void deleteAvion(Avion elem) {
		genRepository.delete(elem);
		
	}

	public Avion getItem(Long idAvion) {
		// TODO Auto-generated method stub
		return genRepository.findById(idAvion).get();
	}
	
	public List<Avion> saveAll(List<Avion>types){
		return genRepository.saveAll(types);
	}
	
}
