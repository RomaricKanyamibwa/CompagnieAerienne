package com.stock.mvc.dao;

import java.util.List;

public interface IGenericDao<T> {
	public T save(T entity);
	public T update(T entity);
	public List<T> selectAll();
	public List<T> selectAll(String sortField, String sort);
	public T getById(Long id);
	
	public void remove(Long id);
	public T findOne(String paramName, Object[] paramValue);
	public T findOne(String[] paramNames, Object[] paramValues);
	public T findOne(String paramName, String paramValue);
	public int findCountBy(String paramName, String paramValue);
	

}
