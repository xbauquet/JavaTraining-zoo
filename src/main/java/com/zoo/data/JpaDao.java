package com.zoo.data;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class JpaDao<K, E> implements Dao<K, E> {
	protected Class<E> entityClass;
	@Inject
	protected EntityManager entityManager;

	public JpaDao() {
		Class<?> genericSuperclass2 = getClass();
		while(!ParameterizedType.class.isAssignableFrom(genericSuperclass2.getGenericSuperclass().getClass())) {
			genericSuperclass2 = genericSuperclass2.getSuperclass();
		}
		ParameterizedType genericSuperclass = (ParameterizedType) genericSuperclass2.getGenericSuperclass();
		this.entityClass = (Class<E>) genericSuperclass.getActualTypeArguments()[1];
	}

	public void persist(E entity) {
		entityManager.persist(entity);
	}

	public void remove(E entity) {
		entityManager.remove(entity);
	}

	public E findById(K id) {
		return entityManager.find(entityClass, id);
	}

	public Collection<E> findAll() {
		Query q = entityManager.createQuery("select a from :table a where a.name = :name");
		q.setParameter("name", "John Doe");
		q.setParameter("table", entityManager);
		List<E> list = q.getResultList();
		return list;
	}
}
