package com.stock.mvc.services.impl;

import java.util.List;

import com.stock.mvc.dao.IRetraiteDao;
import com.stock.mvc.entites.Retraite;
import com.stock.mvc.services.IRetraiteService;

public class RetraiteServiceImpl implements IRetraiteService {
	private IRetraiteDao dao;

	public void setDao(IRetraiteDao dao) {
		this.dao = dao;
	}

	@Override
	public Retraite save(Retraite entity) {
		
		return dao.save(entity);
	}

	@Override
	public Retraite update(Retraite entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Retraite> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Retraite> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField,sort);
	}

	@Override
	public Retraite getById(Long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Retraite findOne(String paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Retraite findOne(String[] paramNames, Object[] paramValues) {
	
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public Retraite findOne(String paramName, String paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
	
		return dao.findCountBy(paramName, paramValue);
	}
	
}
