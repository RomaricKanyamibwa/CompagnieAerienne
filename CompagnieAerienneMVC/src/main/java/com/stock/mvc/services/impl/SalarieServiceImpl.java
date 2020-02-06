package com.stock.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.dao.ISalarieDao;
import com.stock.mvc.entites.Salarie;
import com.stock.mvc.services.ISalarieService;

@Transactional
public class SalarieServiceImpl implements ISalarieService{
	private ISalarieDao dao;

	public void setDao(ISalarieDao dao) {
		this.dao = dao;
	}

	@Override
	public Salarie save(Salarie entity) {
		
		return dao.save(entity);
	}

	@Override
	public Salarie update(Salarie entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Salarie> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Salarie> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField,sort);
	}

	@Override
	public Salarie getById(Long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Salarie findOne(String paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Salarie findOne(String[] paramNames, Object[] paramValues) {
	
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public Salarie findOne(String paramName, String paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
	
		return dao.findCountBy(paramName, paramValue);
	}
	

}
