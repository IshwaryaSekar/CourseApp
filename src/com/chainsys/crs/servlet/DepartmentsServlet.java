package com.chainsys.crs.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.crs.exception.CourseMangnmtException;
import com.chainsys.crs.model.Department;
import com.chainsys.crs.services.DepartmentsServices;

@WebServlet("/DepartmentsServlet")
public class DepartmentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DepartmentsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = "";
		name = request.getParameter("name");
		Department department = new Department();
		department.setName(name);
		DepartmentsServices departmentsServices = new DepartmentsServices();
		try {
			int rows = departmentsServices.addDepartment(department);
			if (rows != 0) {
				request.setAttribute("msg", "success");
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("adddepartment.jsp");
				requestdispatcher.forward(request, response);

			}
		} catch (CourseMangnmtException e) {
			String result = e.getMessage();
			request.setAttribute("msg", result);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("adddepartment.jsp");
			requestdispatcher.forward(request, response);
		}
	}
}
