package companie.aerienne.mvc.services;

import java.util.List;

import companie.aerienne.mvc.entites.Pilote;

public interface IPiloteService {
	public Pilote save(Pilote entity);
	public Pilote update(Pilote entity);
	public List<Pilote> selectAll();
	public List<Pilote> selectAll(String sortField, String sort);
	public Pilote getById(Long id);
	
	public void remove(Long id);
	public Pilote findOne(String paramName, Object[] paramValue);
	public Pilote findOne(String[] paramNames, Object[] paramValues);
	public Pilote findOne(String paramName, String paramValue);
	public int findCountBy(String paramName, String paramValue);
}
