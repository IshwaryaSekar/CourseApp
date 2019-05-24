package com.chainsys.crs.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.crs.services.CourseServices;

@WebServlet("/UserCourseServlet")
public class UserCourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserCourseServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptname = request.getParameter("deptname");
		CourseServices coursesServices = new CourseServices();
		try {
			List<String> courseNameList = new ArrayList<String>();
			courseNameList = coursesServices.displayUserCourses(deptname);

			if (!courseNameList.isEmpty()) {
				request.setAttribute("COURSES", courseNameList);
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("listusercourses.jsp");
				requestdispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
