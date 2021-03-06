package com.compagnie_aerienneboot.rest.models;

import java.io.Serializable;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

public class TypeAvionGenerator 
implements IdentifierGenerator, Configurable{

	private String prefix;

	@Override
	public void configure
	(Type type, Properties params, ServiceRegistry serviceRegistry)
			throws MappingException {
		// TODO Auto-generated method stub
		prefix = params.getProperty("prefix");

	}

	@Override
	public Serializable generate(
			SharedSessionContractImplementor session, Object obj)
					throws HibernateException {
		String query = String.format("select %s from %s", 
				session.getEntityPersister(obj.getClass().getName(), obj)
				.getIdentifierPropertyName(),
				obj.getClass().getSimpleName());

//		Stream ids = session.createQuery(query).stream();
//
//		Long max = ids.map(o -> o.replace(prefix + "-", ""))
//				.mapToLong(Long::parseLong)
//				.max()
//				.orElse(0L);

		return prefix + "-" + 1;//(max + 1);

	}

}
