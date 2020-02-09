package companie.aerienne.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import companie.aerienne.mvc.dao.IConstructeurDao;
import companie.aerienne.mvc.entites.Constructeur;
import companie.aerienne.mvc.services.IConstructeurService;
import companie.aerienne.mvc.services.IGenericService;

@Transactional
public class ConstructeurServiceImpl 
	extends GenericServiceImpl<Constructeur, Long>
	implements IConstructeurService{

}
