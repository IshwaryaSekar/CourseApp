package com.chainsys.crs.servlet;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.crs.services.CourseServices;

@WebServlet("/ViewCoursesServlet")
public class ViewCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCoursesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("course called");
		CourseServices coursesServices = new CourseServices();
		try {
			List<String> courseNameList = new ArrayList<String>();
			courseNameList = coursesServices.displayCourses();

			if (!courseNameList.isEmpty()) {
				request.setAttribute("COURSES", courseNameList);
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("listcourses.jsp");
				requestdispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
