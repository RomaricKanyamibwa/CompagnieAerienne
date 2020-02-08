package companie.aerienne.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import companie.aerienne.mvc.dao.IAeroportDao;
import companie.aerienne.mvc.entites.Aeroport;
import companie.aerienne.mvc.services.IAeroportService;

@Transactional
public class AeroportServiceImpl implements IAeroportService{
	private IAeroportDao dao;

	public void setDao(IAeroportDao dao) {
		this.dao = dao;
	}

	@Override
	public Aeroport save(Aeroport entity) {
		
		return dao.save(entity);
	}

	@Override
	public Aeroport update(Aeroport entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Aeroport> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Aeroport> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField,sort);
	}

	@Override
	public Aeroport getById(String id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(String id) {
		dao.remove(id);
	}

	@Override
	public Aeroport findOne(String paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Aeroport findOne(String[] paramNames, Object[] paramValues) {
	
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public Aeroport findOne(String paramName, String paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
	
		return dao.findCountBy(paramName, paramValue);
	}
	

}
