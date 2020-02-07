package companie.aerienne.mvc.services;

import java.util.List;

import companie.aerienne.mvc.entites.Aeroport;

public interface IAeroportService {
	public Aeroport save(Aeroport entity);
	public Aeroport update(Aeroport entity);
	public List<Aeroport> selectAll();
	public List<Aeroport> selectAll(String sortField, String sort);
	public Aeroport getById(Long id);
	
	public void remove(Long id);
	public Aeroport findOne(String paramName, Object[] paramValue);
	public Aeroport findOne(String[] paramNames, Object[] paramValues);
	public Aeroport findOne(String paramName, String paramValue);
	public int findCountBy(String paramName, String paramValue);
}
