package services;

import java.util.List;

import javax.persistence.EntityManager;

import com.ameed.jpa.JPAUtil;
import com.ameed.jpa.dao.CourseDAO;
import com.ameed.jpa.dao.LecturerDAO;
import com.ameed.jpa.entities.Course;
import com.ameed.jpa.entities.Lecturer;

public class MyService {
	private final EntityManager entityManager;
	private final CourseDAO courseDAO;
	private final LecturerDAO lecturerDAO;

	public MyService() {
		this.entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		this.courseDAO = new CourseDAO(entityManager);
		this.lecturerDAO = new LecturerDAO(entityManager);
	}

	public void end() {
		this.entityManager.close();
	}

	public void listCourses() {
		List<Course> courses = courseDAO.listAll();
		for (Course course : courses) {
			System.out.println(course);
		}
	}

	public void createOrUpdateCourse(String courseName, String lecturerName, String language, Float average) {
		Course course = courseDAO.findByName(courseName);
		if (course == null) {
			System.out.println("No course with the name '" + courseName + "' was found");
			course = new Course();
		}
		course.setName(courseName);
		course.setLanguage(language);
		course.setAverage(average);
		
		Lecturer lecturer = lecturerDAO.findByLecturerName(lecturerName);
		if (lecturer == null) {
			System.out.println("No lecturer with the name '" + lecturerName + "' was found");
			lecturer = lecturerDAO.createNew(lecturerName);
			System.out.println("Created a new lecturer. ID: " + lecturer.getId());
		}
		course.setLecturer(lecturer);
		if (course.getCourseId() == null) {
			// we need to save
			courseDAO.save(course);
			System.out.println("Created a new course. ID: " + course.getCourseId());
		} else {
			courseDAO.update(course);
		}
	}
}
