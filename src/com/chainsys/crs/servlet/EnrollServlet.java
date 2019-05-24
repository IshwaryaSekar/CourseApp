package com.chainsys.crs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.chainsys.crs.model.Course;
import com.chainsys.crs.model.User;
import com.chainsys.crs.services.CourseServices;
import com.chainsys.crs.services.RegisterServices;

@WebServlet("/EnrollServlet")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EnrollServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String coursename = request.getParameter("coursename");
		HttpSession session = request.getSession(false);
		session.getAttribute("name");
		Course course1 = new Course();
		course1.setName(request.getParameter("coursename"));
		CourseServices courseServices = new CourseServices();
		RegisterServices register = new RegisterServices();
		Course course = new Course();
		User user = new User();
		User user1 = new User();
		user.setName((String) session.getAttribute("name"));
		user1 = register.findUserId(user);
		course = courseServices.findCourseId(course1);
		try {
			int rows = courseServices.addStudentEnrollment(course, user1);
			if (rows > 0) {
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("ViewMaterialsServlet");
				requestdispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
