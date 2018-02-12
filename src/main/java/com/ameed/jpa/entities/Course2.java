package com.ameed.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "course_id")
	private Integer courseId;

	private String name;

	private String lecturer;

	private String language;

	private Float average;

	public Course2() {
	}

	public Course2(Integer courseId, String name, String lecturer, String language, Float average) {
		super();
		this.courseId = courseId;
		this.name = name;
		this.lecturer = lecturer;
		this.language = language;
		this.average = average;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLecturer() {
		return lecturer;
	}

	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", lecturer=" + lecturer + ", language=" + language
				+ ", average=" + average + "]";
	}

}
