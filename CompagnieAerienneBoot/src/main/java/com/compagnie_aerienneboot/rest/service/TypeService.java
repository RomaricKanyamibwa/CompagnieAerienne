package com.compagnie_aerienneboot.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.compagnie_aerienneboot.rest.models.Type;

@Component
public class TypeService {
	
	private static List<Type> types = new ArrayList<Type>();
	static
	{
//		Type sal1 = new Type(1L,"Albert", "Legrand", 123456);
//		Type sal2 = new Type(2L,"Cirille Fiona", "El Riannon", 123456);
//		Type sal3 = new Type(3L,"Geralt", "of Rivia", 123456);
//		Type sal4 = new Type(4L,"Yennefer", "of Vengerberg", 123456);
////		sal1.setId(1L);
////		sal2.setId(2L);
////		sal3.setId(3L);
////		sal4.setId(4L);
////		types.add(sal1);
////		types.add(sal2);
////		types.add(sal3);
////		types.add(sal4);
		
	}
	
	public List<Type> retrieveAllTypes() {
		return types;		
	}
	
	public Type retrieveType(String typeId)
	{
		for (Type type : types) {
			if (type.getTypeAvion().equals(typeId)) {
				return type;
			}
		}
		return null; 
	}
}
