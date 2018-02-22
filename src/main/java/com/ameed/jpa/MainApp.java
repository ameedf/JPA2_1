package com.ameed.jpa;

import services.MyService;

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
		MyService service = new MyService();
		service.listCourses();
		service.createOrUpdateCourse("Dummy course 4", "Lecturer 4", "NONE", 88.0f);
		service.createOrUpdateCourse("Dummy course 4", "Lecturer 5", "dummy", 67.0f);
		service.listCourses();
		service.end();
	}
}
