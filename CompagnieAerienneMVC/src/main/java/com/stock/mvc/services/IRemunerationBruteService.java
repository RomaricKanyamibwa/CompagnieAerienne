package com.stock.mvc.services;

import java.util.List;

import com.stock.mvc.entites.RemunerationBrute;

public interface IRemunerationBruteService {
	public RemunerationBrute save(RemunerationBrute entity);
	public RemunerationBrute update(RemunerationBrute entity);
	public List<RemunerationBrute> selectAll();
	public List<RemunerationBrute> selectAll(String sortField, String sort);
	public RemunerationBrute getById(Long id);
	
	public void remove(Long id);
	public RemunerationBrute findOne(String paramName, Object[] paramValue);
	public RemunerationBrute findOne(String[] paramNames, Object[] paramValues);
	public RemunerationBrute findOne(String paramName, String paramValue);
	public int findCountBy(String paramName, String paramValue);
}
