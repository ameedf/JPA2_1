package com.ameed.jpa;

import com.ameed.jpa.entities.Course1DAO;
import com.ameed.jpa.entities.Course2DAO;

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
		Course1DAO dao1 = new Course1DAO();
		dao1.listAll();
		
		Course2DAO dao2 = new Course2DAO();
		dao2.createNew("test2-jpa", "lecturer2-jpa", "language2-jpa", 333.3F);
		
		dao1.listAll();
		dao2.listAll();
	}
}
