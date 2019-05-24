package com.chainsys.crs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.crs.model.Course;
import com.chainsys.crs.services.CourseServices;

@WebServlet("/CourseDescriptionServlet")
public class CourseDescriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CourseDescriptionServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String coursename = request.getParameter("coursename");
		CourseServices coursesServices = new CourseServices();
		try {
			List<Course> courseDesc = null;
			courseDesc = coursesServices.displayCoursesDesc(coursename);
			request.setAttribute("DESCRIPTION", courseDesc);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("usercoursedesc.jsp");
			requestdispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();

		}

	}

}
