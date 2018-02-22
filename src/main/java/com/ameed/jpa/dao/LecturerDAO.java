package com.ameed.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.ameed.jpa.entities.Lecturer;

public class LecturerDAO extends AbstractDao {

	public LecturerDAO(EntityManager entityManager) {
		super(entityManager);
	}

	public void listAll() {
		String queryString = "select lec from Lecturer lec";
		List<Lecturer> lecturers = executeQuery(queryString);
		for (Lecturer lecturer : lecturers) {
			System.out.println(lecturer);
		}
	}

	public Lecturer createNew(String name) {
		Lecturer lec = new Lecturer(name);
		super.save(lec);
		return lec;
	}

	public Lecturer findByLecturerName(String lecturerName) {
		String queryString = "select lec from Lecturer lec where name = '" + lecturerName + "'";
		List<Lecturer> lecturers = executeQuery(queryString);
		if (lecturers.isEmpty()) {
			return null;
		}

		return lecturers.get(0);
	}

	private List<Lecturer> executeQuery(String queryString) {
		TypedQuery<Lecturer> query = entityManager.createQuery(queryString, Lecturer.class);
		List<Lecturer> lecturers = query.getResultList();
		return lecturers;
	}

}
