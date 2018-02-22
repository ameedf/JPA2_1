package com.ameed.jpa.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ameed.jpa.JPAUtil;

public class CourseDAO {

	public void listAll() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

		String queryString = "select c from Course c";
		TypedQuery<Course> query = entityManager.createQuery(queryString, Course.class);
		List<Course> courses = query.getResultList();
		for (Course course : courses) {
			System.out.println(course);
		}
		entityManager.close();
	}
}
