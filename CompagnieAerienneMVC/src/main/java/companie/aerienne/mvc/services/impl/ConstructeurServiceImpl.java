package companie.aerienne.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import companie.aerienne.mvc.dao.IConstructeurDao;
import companie.aerienne.mvc.entites.Constructeur;
import companie.aerienne.mvc.services.IConstructeurService;
import companie.aerienne.mvc.services.IGenericService;

@Transactional
public class ConstructeurServiceImpl implements IGenericService<Constructeur, Long>{
	private IConstructeurDao dao;

	public void setDao(IConstructeurDao dao) {
		this.dao = dao;
	}

	@Override
	public Constructeur save(Constructeur entity) {
		
		return dao.save(entity);
	}

	@Override
	public Constructeur update(Constructeur entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Constructeur> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Constructeur> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField,sort);
	}

	@Override
	public Constructeur getById(Long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Constructeur findOne(String paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Constructeur findOne(String[] paramNames, Object[] paramValues) {
	
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public Constructeur findOne(String paramName, String paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
	
		return dao.findCountBy(paramName, paramValue);
	}
	

}
