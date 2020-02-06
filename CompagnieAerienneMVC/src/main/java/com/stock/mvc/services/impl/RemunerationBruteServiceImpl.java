package com.stock.mvc.services.impl;

import java.util.List;

import com.stock.mvc.dao.IRemunerationBruteDao;
import com.stock.mvc.entites.RemunerationBrute;
import com.stock.mvc.services.IRemunerationBruteService;

public class RemunerationBruteServiceImpl implements IRemunerationBruteService {
	private IRemunerationBruteDao dao;

	public void setDao(IRemunerationBruteDao dao) {
		this.dao = dao;
	}

	@Override
	public RemunerationBrute save(RemunerationBrute entity) {
		
		return dao.save(entity);
	}

	@Override
	public RemunerationBrute update(RemunerationBrute entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<RemunerationBrute> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<RemunerationBrute> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField,sort);
	}

	@Override
	public RemunerationBrute getById(Long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public RemunerationBrute findOne(String paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RemunerationBrute findOne(String[] paramNames, Object[] paramValues) {
	
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public RemunerationBrute findOne(String paramName, String paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
	
		return dao.findCountBy(paramName, paramValue);
	}
	
	
}
