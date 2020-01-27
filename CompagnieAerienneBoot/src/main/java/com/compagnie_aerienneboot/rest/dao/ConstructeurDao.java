package com.compagnie_aerienneboot.rest.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compagnie_aerienneboot.rest.models.Constructeur;
import com.compagnie_aerienneboot.rest.repository.ConstructeurRepository;


@Service
public class ConstructeurDao {
	
	@Autowired
	ConstructeurRepository constructeurRepository;
	
	public List<Constructeur> getConstructeurs(){
		return constructeurRepository.findAll();
	}
	
	public Constructeur saveConstructeur(Constructeur constructeur)
	{
		return constructeurRepository.save(constructeur);
	}
	
	public Constructeur getConstructeur(Long id) {
		return constructeurRepository.getOne(id);
	}

	public Constructeur updateConstructeur(@Valid Constructeur constructeur) {
		// TODO Auto-generated method stub
		return constructeurRepository.saveAndFlush(constructeur);
	}

	public void deleteConstructeur(Constructeur sal) {
		constructeurRepository.delete(sal);
		
	}

	public Constructeur constructeurItem(Long idSal) {
		// TODO Auto-generated method stub
		return constructeurRepository.findById(idSal).get();
	}
	
	public List<Constructeur> saveAll(List<Constructeur>constructeurs){
		return constructeurRepository.saveAll(constructeurs);
	}
	
}
