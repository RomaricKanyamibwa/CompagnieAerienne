package com.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.IEmployeurDao;
import com.stock.mvc.entites.Employeur;
import com.stock.mvc.services.IEmployeurService;
 
@Transactional
public class EmployeurServiceImpl implements IEmployeurService {
	private IEmployeurDao dao;

	public void setDao(IEmployeurDao dao) {
		this.dao = dao;
	}

	@Override
	public Employeur save(Employeur entity) {
		
		return dao.save(entity);
	}

	@Override
	public Employeur update(Employeur entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Employeur> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Employeur> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField,sort);
	}

	@Override
	public Employeur getById(Long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Employeur findOne(String paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employeur findOne(String[] paramNames, Object[] paramValues) {
	
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public Employeur findOne(String paramName, String paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
	
		return dao.findCountBy(paramName, paramValue);
	}

}
