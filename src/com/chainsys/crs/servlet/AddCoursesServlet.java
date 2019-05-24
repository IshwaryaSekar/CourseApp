package com.chainsys.crs.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.crs.exception.CourseMangnmtException;
import com.chainsys.crs.model.Author;
import com.chainsys.crs.model.Course;
import com.chainsys.crs.model.Department;
import com.chainsys.crs.services.CourseServices;

@WebServlet("/AddCoursesServlet")
public class AddCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddCoursesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		LocalDate startDate = LocalDate.parse(request.getParameter("start_date"));
		LocalDate endDate = LocalDate.parse(request.getParameter("end_date"));
		String dpmtname = request.getParameter("departmentName");
		String authorname = request.getParameter("authorName");
		String learn = request.getParameter("learn");
		String requirements = request.getParameter("requirements");
		Course course = new Course();
		course.setName(name);
		course.setStartDate(startDate);
		course.setEndDate(endDate);
		course.setWhere_you_will_learn(learn);
		course.setRequirements(requirements);
		Department department = new Department();
		department.setName(dpmtname);
		course.setDepartment(department);
		Author author = new Author();
		author.setName(authorname);
		course.setAuthor(author);
		CourseServices coursesServices = new CourseServices();
		try {
			int result = coursesServices.findByDepartmentName(department);
			int result1 = coursesServices.findByAuthorName(author);
			course.setDepartment_id(result);
			course.setCourse_author_id(result1);
			int rows = coursesServices.addCourse(course);
			if (rows != 0) {
				request.setAttribute("msg", "success");
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("addcourses.jsp");
				requestdispatcher.forward(request, response);
			}
		} catch (CourseMangnmtException e) {
			String result = e.getMessage();
			request.setAttribute("msg", result);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("addcourses.jsp");
			requestdispatcher.forward(request, response);
		}
	}
}
