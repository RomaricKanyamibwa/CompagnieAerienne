package companie.aerienne.mvc.services.impl;

import org.springframework.transaction.annotation.Transactional;

import companie.aerienne.mvc.entites.Affectation;
import companie.aerienne.mvc.entites.PK_KeyAffectation;
import companie.aerienne.mvc.services.IAffectationService;

@Transactional
public class AffectationServiceImpl 
	extends GenericServiceImpl<Affectation, PK_KeyAffectation>
	implements IAffectationService{

}
