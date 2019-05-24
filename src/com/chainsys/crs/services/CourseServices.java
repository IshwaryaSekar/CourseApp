package com.chainsys.crs.services;

import java.util.ArrayList;
import java.util.List;
import com.chainsys.crs.dao.CourseEnrollmentDAO;
import com.chainsys.crs.dao.CoursesDAO;
import com.chainsys.crs.exception.CourseException;
import com.chainsys.crs.model.Author;
import com.chainsys.crs.model.Course;
import com.chainsys.crs.model.Department;
import com.chainsys.crs.model.User;

public class CourseServices {
	public int findByDepartmentName(Department department) {
		CoursesDAO coursesdao = new CoursesDAO();
		int result = 0;
		try {
			result = coursesdao.findByDepartmentName(department);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int findByAuthorName(Author author) {
		CoursesDAO coursesdao = new CoursesDAO();
		int result1 = 0;
		try {
			result1 = coursesdao.findByAuthorName(author);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result1;
	}

	public int addCourse(Course course) throws CourseException {
		CoursesDAO coursesdao = new CoursesDAO();
		int rows = 0;
		try {
			rows = coursesdao.addCourse(course);
		} catch (Exception e) {
			throw new CourseException(e.getMessage());

		}
		return rows;
	}

	public Course findCourseId(Course course) {
		Course course1 = new Course();
		CourseEnrollmentDAO courseEnrollmentDAO = new CourseEnrollmentDAO();
		try {
			course1 = courseEnrollmentDAO.findByCourseId(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course1;
	}

	public List<String> displayCourses() throws Exception {
		CoursesDAO coursesdao = new CoursesDAO();
		List<String> courseNameList = new ArrayList<String>();
		try {
			courseNameList = coursesdao.displayCourses();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseNameList;
	}

	public int addStudentEnrollment(Course course, User user) throws Exception {
		CourseEnrollmentDAO courseEnrollmentDAO = new CourseEnrollmentDAO();
		int rows = 0;
		try {
			rows = courseEnrollmentDAO.addStudentEnrollment(course, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rows;
	}

	public List<String> displayUserCourses(String deptname) {
		CoursesDAO coursesdao = new CoursesDAO();
		List<String> courseNameList = new ArrayList<String>();
		try {
			courseNameList = coursesdao.displayUserCourses(deptname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseNameList;
	}

	public List<Course> displayCoursesDesc(String coursename) {
		CoursesDAO coursesdao = new CoursesDAO();
		List<Course> courseDesc = new ArrayList<Course>();
		try {
			courseDesc = coursesdao.displayCourseDesc(coursename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseDesc;
	}

}
