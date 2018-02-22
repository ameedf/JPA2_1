package com.ameed.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ameed.jpa.entities.Course;

public class CourseDAO extends AbstractDao {

	public CourseDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public List<Course> listAll() {
		String queryString = "select c from Course c";
		List<Course> courses = executeQuery(queryString);
		return courses;
	}

	public Course findByName(String courseName) {
		String queryString = "select c from Course c where name = '" + courseName + "'";
		List<Course> courses = executeQuery(queryString);
		if (courses.isEmpty()) {
			return null;
		}
		return courses.get(0);
	}

	private List<Course> executeQuery(String queryString) {
		TypedQuery<Course> query = entityManager.createQuery(queryString, Course.class);
		List<Course> courses = query.getResultList();
		return courses;
	}

}
