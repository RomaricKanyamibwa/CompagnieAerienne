package com.stock.mvc.services.impl;

import java.util.List;

import com.stock.mvc.dao.IImpotsDao;
import com.stock.mvc.entites.Impots;
import com.stock.mvc.services.IImpotsService;

public class ImpotsServiceImpl implements IImpotsService{
	
	private IImpotsDao dao;

	public void setDao(IImpotsDao dao) {
		this.dao = dao;
	}

	@Override
	public Impots save(Impots entity) {
		
		return dao.save(entity);
	}

	@Override
	public Impots update(Impots entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Impots> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Impots> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField,sort);
	}

	@Override
	public Impots getById(Long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Impots findOne(String paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Impots findOne(String[] paramNames, Object[] paramValues) {
	
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public Impots findOne(String paramName, String paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
	
		return dao.findCountBy(paramName, paramValue);
	}
	

}
