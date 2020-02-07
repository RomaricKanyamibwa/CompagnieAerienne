package companie.aerienne.mvc.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import companie.aerienne.mvc.dao.IPiloteDao;
import companie.aerienne.mvc.entites.Pilote;
import companie.aerienne.mvc.services.IPiloteService;

@Transactional
public class PiloteServiceImpl implements IPiloteService{
	private IPiloteDao dao;

	public void setDao(IPiloteDao dao) {
		this.dao = dao;
	}

	@Override
	public Pilote save(Pilote entity) {
		
		return dao.save(entity);
	}

	@Override
	public Pilote update(Pilote entity) {
		
		return dao.update(entity);
	}

	@Override
	public List<Pilote> selectAll() {
		
		return dao.selectAll();
	}

	@Override
	public List<Pilote> selectAll(String sortField, String sort) {
		
		return dao.selectAll(sortField,sort);
	}

	@Override
	public Pilote getById(Long id) {
		
		return dao.getById(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Pilote findOne(String paramName, Object[] paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pilote findOne(String[] paramNames, Object[] paramValues) {
	
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public Pilote findOne(String paramName, String paramValue) {
		
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
	
		return dao.findCountBy(paramName, paramValue);
	}
	

}
