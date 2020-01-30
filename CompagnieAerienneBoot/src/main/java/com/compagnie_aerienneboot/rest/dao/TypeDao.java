package com.compagnie_aerienneboot.rest.dao;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.compagnie_aerienneboot.rest.models.Type;
import com.compagnie_aerienneboot.rest.repository.TypeRepository;


@Service
public class TypeDao {
	
	@Autowired
	TypeRepository typeRepository;
	
	public List<Type> getTypes(){
		return typeRepository.findAll();
	}
	
	public Type saveType(Type type)
	{
		return typeRepository.save(type);
	}
	
	public Type getType(String id) {
		return typeRepository.getOne(id);
	}

	public Type updateType(@Valid Type type) {
		// TODO Auto-generated method stub
		return typeRepository.saveAndFlush(type);
	}

	public void deleteType(Type type) {
		typeRepository.delete(type);
		
	}

	public Type typeItem(String idType) {
		// TODO Auto-generated method stub
		return typeRepository.findById(idType).get();
	}
	
	public List<Type> saveAll(List<Type>types){
		return typeRepository.saveAll(types);
	}
	
}
