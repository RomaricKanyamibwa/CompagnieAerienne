package companie.aerienne.mvc.services.impl;

import org.springframework.transaction.annotation.Transactional;

import companie.aerienne.mvc.entites.Aeroport;
import companie.aerienne.mvc.services.IAeroportService;

@Transactional
public class AeroportServiceImpl 
	extends GenericServiceImpl<Aeroport, String>
	implements IAeroportService{

}
