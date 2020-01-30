package com.compagnie_aerienneboot.rest.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compagnie_aerienneboot.rest.models.Pilote;
import com.compagnie_aerienneboot.rest.repository.PiloteRepository;


@Service
public class PiloteDao {
	
	@Autowired
	PiloteRepository piloteRepository;
	
	public List<Pilote> getPilotes(){
		return piloteRepository.findAll();
	}
	
	public Pilote savePilote(Pilote pilote)
	{
		return piloteRepository.save(pilote);
	}
	
	public Pilote getPilote(Integer id) {
		return piloteRepository.getOne(id);
	}

	public Pilote updatePilote(@Valid Pilote pilote) {
		// TODO Auto-generated method stub
		return piloteRepository.saveAndFlush(pilote);
	}

	public void deletePilote(Pilote pil) {
		piloteRepository.delete(pil);
		
	}

	public Pilote piloteItem(Integer idPil) {
		// TODO Auto-generated method stub
		return piloteRepository.findById(idPil).get();
	}
	
	public List<Pilote> saveAll(List<Pilote>pilotes){
		return piloteRepository.saveAll(pilotes);
	}
	
}
