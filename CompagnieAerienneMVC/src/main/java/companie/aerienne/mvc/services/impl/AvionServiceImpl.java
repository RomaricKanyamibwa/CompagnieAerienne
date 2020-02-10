package companie.aerienne.mvc.services.impl;

import org.springframework.transaction.annotation.Transactional;

import companie.aerienne.mvc.entites.Avion;
import companie.aerienne.mvc.services.IAvionService;

@Transactional
public class AvionServiceImpl
	extends GenericServiceImpl<Avion, Long>
	implements IAvionService{
	
}
