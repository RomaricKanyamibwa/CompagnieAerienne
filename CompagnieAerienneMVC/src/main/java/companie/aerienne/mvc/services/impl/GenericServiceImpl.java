package companie.aerienne.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import companie.aerienne.mvc.dao.IGenericDao;
import companie.aerienne.mvc.services.IGenericService;

@Transactional
public class GenericServiceImpl<T,E> implements IGenericService<T, E>{
	private IGenericDao<T,E> dao;

	public void setDao(IGenericDao<T,E> dao) {
		this.dao = dao;
	}

	@Override
	public T save(T entity) {
		
		return dao.save(entity);
	}

	@Override
	public T update(T entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<T> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<T> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField,sort);
	}

	@Override
	public T getById(E id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(E id) {
		dao.remove(id);
	}

	@Override
	public T findOne(String paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T findOne(String[] paramNames, Object[] paramValues) {
	
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public T findOne(String paramName, String paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
	
		return dao.findCountBy(paramName, paramValue);
	}
	

}
