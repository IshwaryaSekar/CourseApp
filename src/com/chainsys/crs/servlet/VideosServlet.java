package com.chainsys.crs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.crs.services.MaterialsServices;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/VideosServlet")
public class VideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VideosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String departmentAction = request.getParameter("departmentAction");
		if ("bindCourse".equals(departmentAction)) {
			MaterialsServices materialsServices = new MaterialsServices();
			try {
				List<String> courseList = materialsServices.displayCourses();
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String crsList = gson.toJson(courseList);
				response.getWriter().write(crsList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
