package com.ameed.jpa;

import com.ameed.jpa.entities.CourseDAO;

public class MainApp {
	public static void main(String[] args) {
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace();
		}
		JPAUtil.shutdown();
	}

	private static void test() {
		CourseDAO dao = new CourseDAO();
		dao.listAll();
	}
}
