package com.ameed.jpa.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.ameed.jpa.JPAUtil;

public class Course1DAO {
	public void listAll() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		// entityManager.getTransaction().begin();

		// Check database version
		String sql = "select * from courses";

		Query query = entityManager.createNativeQuery(sql);
		List<Object[]> resultList = query.getResultList();
		for (Object[] row : resultList) {
			Integer courseId = (Integer) row[0];
			String name = (String) row[1];
			String lecturer = (String) row[2];
			String language = (String) row[3];
			Float average = (Float) row[4];
			Course1 c = new Course1(courseId, name, lecturer, language, average);
			System.out.println(c);
		}

		// entityManager.getTransaction().commit();
		entityManager.close();
	}
}
