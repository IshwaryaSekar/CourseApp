package com.chainsys.crs.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.crs.services.DepartmentsServices;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CoursesServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String departmentAction = request.getParameter("departmentAction");
		if ("bindDepartment".equals(departmentAction)) {
			DepartmentsServices departmentsServices = new DepartmentsServices();
			try {
				List<String> departmentList = departmentsServices.displayDepartments();
				Gson gson = new GsonBuilder().setPrettyPrinting().create();
				String deptList = gson.toJson(departmentList);
				response.getWriter().write(deptList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
