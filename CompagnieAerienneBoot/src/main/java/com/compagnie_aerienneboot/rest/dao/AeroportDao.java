package com.compagnie_aerienneboot.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compagnie_aerienneboot.rest.models.Aeroport;
import com.compagnie_aerienneboot.rest.repository.AeroportRepository;

@Service
public class AeroportDao {
	
	@Autowired
	AeroportRepository aeroportrepository;
	
	public List<Aeroport> getAeroport() {
		return aeroportrepository.findAll();
	}
	public Aeroport saveAeoroport (Aeroport airport) {
		return Aeroport.save(airport);
	}
	public Aeroport updateAeoroport (Aeroport airport) {
		return Aeroport.update(airport);
	}
	public void deleteAeroport(Aeroport airport) {
		Aeroport.delete(airport);
	}
	public Aeroport getAeroport(String idAeroport) {
		return aeroportrepository.getOne(idAeroport);
	}
	public Aeroport AeroportItem(String idAeroport) {
		return aeroportrepository.findById(idAeroport).get();
	}
	public List<Aeroport> saveAll(List<Aeroport>airport){
		return aeroportrepository.saveAll(airport);
	}
}
