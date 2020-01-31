package com.compagnie_aerienneboot.rest.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compagnie_aerienneboot.rest.models.Vol;
import com.compagnie_aerienneboot.rest.repository.VolRepository;


@Service
public class VolDao {
	
	@Autowired
	VolRepository volRepository;
	
	public List<Vol> getVols(){
		return volRepository.findAll();
	}
	
	public Vol saveVol(Vol vol)
	{
		return volRepository.save(vol);
	}
	
	public Vol getVol(String id) {
		return volRepository.getOne(id);
	}

	public Vol updateVol(@Valid Vol vol) {
		// TODO Auto-generated method stub
		return volRepository.saveAndFlush(vol);
	}

	public void deleteVol(Vol vol) {
		volRepository.delete(vol);
	}

	public Vol volItem(String idVol) {
		// TODO Auto-generated method stub
		return volRepository.findById(idVol).get();
	}
	
	public List<Vol> saveAll(List<Vol>vols){
		return volRepository.saveAll(vols);
	}
	
}
