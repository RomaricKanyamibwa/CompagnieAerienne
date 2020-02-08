package companie.aerienne.mvc.services;

import java.util.List;


public interface IGenericService<T,E> {
	public T save(T entity);
	public T update(T entity);
	public List<T> selectAll();
	public List<T> selectAll(String sortField, String sort);
	public T getById(E id);
	
	public void remove(E id);
	public T findOne(String paramName, Object[] paramValue);
	public T findOne(String[] paramNames, Object[] paramValues);
	public T findOne(String paramName, String paramValue);
	public int findCountBy(String paramName, String paramValue);
}
