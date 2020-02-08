package companie.aerienne.mvc.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import companie.aerienne.mvc.dao.IGenericDao;

@SuppressWarnings("unchecked")
public class GenericDaoImpl<T,E> implements IGenericDao<T,E> {
	
	@PersistenceContext
	EntityManager em;
	
	private Class<T> type;
	

	public GenericDaoImpl() {
		super();
		Type f = getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType)f;
		type = (Class<T>)pt.getActualTypeArguments()[0];
	}

	public Class<T> getType() {
		return type;
	}

	@Override
	public T save(T entity) {
		//Enregistre un entit� T
		em.persist(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		
		return em.merge(entity);
	}

	@Override
	public List<T> selectAll() {
Query query = em.createQuery("select t from "+type.getSimpleName()+" t");
		return query.getResultList();  //Retourne une liste de type T
	}

	@Override
	public List<T> selectAll(String sortField, String sort) {
		//TODO
		return null;
	}

	@Override
	public T getById(E id) {
		
		return em.find(type, id);
	}

	@Override
	public void remove(E id) {
		T tab = em.getReference(type, id);
		em.remove(tab);
	}

	@Override
	public T findOne(String paramName, Object[] paramValue) {
		//Query query = em.createQuery("select t from"+type.getSimpleName()+" t");
		return null;
	}
	@Override
	public T findOne(String paramName, String paramValue) {
		Query query = em.createQuery("select t from"+type.getSimpleName()+
				" t where" +paramName+"= :x");
		query.setParameter("x", paramValue);
		return query.getResultList().size()>0 ? (T)query.getResultList().get(0): null;
	}

	@Override
	public T findOne(String[] paramNames, Object[] paramValues) {
		if(paramNames.length != paramValues.length) {
		return null;}
		String queryString = "select e from"+type.getSimpleName()+ " e where";
		int len = paramNames.length;
		for(int i=0;i<len; i++) {
			queryString +="e."+paramNames[i]+"=:x"+i;
			if((i+1)<len) {
				queryString += "and";
			}
		}
		Query query = em.createQuery(queryString);
		for(int i=0;i<paramValues.length; i++) {
			query.setParameter("x"+i, paramValues[i]);
				}
		return query.getResultList().size()>0 ? (T)query.getResultList().get(0): null;
		
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		Query query = em.createQuery("select t from"+type.getSimpleName()+
				" t where" +paramName+"= :x");
		query.setParameter(paramName, paramValue);  //retourne le nombre d'�l�ment contenu dans la liste type
		return query.getResultList().size()>0 ? ((Long) query.getSingleResult()).intValue(): null;
	}

	

}
