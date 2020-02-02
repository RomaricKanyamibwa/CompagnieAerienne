package com.compagnie_aerienneboot.rest.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compagnie_aerienneboot.rest.models.Aeroport;
import com.compagnie_aerienneboot.rest.repository.AeroportRepository;

@Service
public class AeroportDao {
	
	@Autowired
	AeroportRepository aeroportRepository;
	
	public List<Aeroport> getAeroports() {
		return aeroportRepository.findAll();
	}
	public Aeroport saveAeoroport (Aeroport airport) {
		return aeroportRepository.save(airport);
	}
	public Aeroport updateAeoroport (@Valid Aeroport airport) {
		return aeroportRepository.saveAndFlush(airport);
	}
	public void deleteAeroport(Aeroport airport) {
		aeroportRepository.delete(airport);
	}
	public Aeroport getAeroport(String idAeroport) {
		return aeroportRepository.getOne(idAeroport);
	}
	public Aeroport aeroportItem(String idAeroport) {
		return aeroportRepository.findById(idAeroport).get();
	}
	public List<Aeroport> saveAll(List<Aeroport>airport){
		return aeroportRepository.saveAll(airport);
	}
}
