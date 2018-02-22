package com.ameed.jpa.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ameed.jpa.JPAUtil;

public class LecturerDAO {

	public void listAll() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

		String sql = "select lec from Lecturer lec";
		TypedQuery<Lecturer> query = entityManager.createQuery(sql, Lecturer.class);
		List<Lecturer> lecturers = query.getResultList();
		for (Lecturer lecturer : lecturers) {
			System.out.println(lecturer);
		}

		entityManager.close();
	}
	
	public Lecturer createNew(String name) {
		Lecturer lec = new Lecturer(name);
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(lec);
		em.getTransaction().commit();
		return lec;
	}
}
