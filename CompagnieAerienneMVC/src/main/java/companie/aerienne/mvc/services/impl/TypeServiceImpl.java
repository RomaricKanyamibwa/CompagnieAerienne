package companie.aerienne.mvc.services.impl;

import org.springframework.transaction.annotation.Transactional;

import companie.aerienne.mvc.entites.Type;
import companie.aerienne.mvc.services.ITypeService;

@Transactional
public class TypeServiceImpl 
	extends GenericServiceImpl<Type, String>
	implements ITypeService{

}
