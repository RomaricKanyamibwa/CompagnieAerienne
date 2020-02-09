package companie.aerienne.mvc.services.impl;

import org.springframework.transaction.annotation.Transactional;

import companie.aerienne.mvc.entites.Pilote;
import companie.aerienne.mvc.services.IPiloteService;

@Transactional
public class PiloteServiceImpl
	extends GenericServiceImpl<Pilote, Long>
	implements IPiloteService{
	
}
