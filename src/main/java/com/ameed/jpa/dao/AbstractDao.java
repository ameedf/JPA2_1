package com.ameed.jpa.dao;

import javax.persistence.EntityManager;

public abstract class AbstractDao {
	protected final EntityManager entityManager;

	public AbstractDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void save(Object newEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(newEntity);
		entityManager.getTransaction().commit();
	}
	
	public void update(Object entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
	}

}
