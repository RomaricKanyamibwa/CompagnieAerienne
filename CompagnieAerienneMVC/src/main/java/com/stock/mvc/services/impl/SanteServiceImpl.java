package com.stock.mvc.services.impl;

import java.util.List;

import com.stock.mvc.dao.ISanteDao;
import com.stock.mvc.entites.Sante;
import com.stock.mvc.services.ISanteService;



public class SanteServiceImpl implements ISanteService{
	private ISanteDao dao;

	public void setDao(ISanteDao dao) {
		this.dao = dao;
	}

	@Override
	public Sante save(Sante entity) {
		
		return dao.save(entity);
	}

	@Override
	public Sante update(Sante entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Sante> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Sante> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField,sort);
	}

	@Override
	public Sante getById(Long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Sante findOne(String paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sante findOne(String[] paramNames, Object[] paramValues) {
	
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public Sante findOne(String paramName, String paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
	
		return dao.findCountBy(paramName, paramValue);
	}
	

}