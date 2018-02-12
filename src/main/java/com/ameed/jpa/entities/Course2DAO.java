package com.ameed.jpa.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ameed.jpa.JPAUtil;

public class Course2DAO {

	public void listAll() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

		String sql = "select c from Course2 c";
		TypedQuery<Course2> query = entityManager.createQuery(sql, Course2.class);
		List<Course2> courses = query.getResultList();
		for (Course2 course2 : courses) {
			System.out.println(course2);
		}

		entityManager.close();
	}

	public Course2 createNew(String name, String lecturer, String language, Float average) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();
		Course2 course = new Course2(null, name, lecturer, language, average);
		entityManager.persist(course);
		entityManager.getTransaction().commit();
		entityManager.close();
		return course;

	}
}
