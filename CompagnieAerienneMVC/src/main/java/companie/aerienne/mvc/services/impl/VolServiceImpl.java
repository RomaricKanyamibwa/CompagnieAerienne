package companie.aerienne.mvc.services.impl;

import org.springframework.transaction.annotation.Transactional;

import companie.aerienne.mvc.entites.Vol;
import companie.aerienne.mvc.services.IVolService;

@Transactional
public class VolServiceImpl 
	extends GenericServiceImpl<Vol, String>
	implements IVolService{

}
