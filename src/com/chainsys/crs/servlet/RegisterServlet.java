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
import com.chainsys.crs.model.User;
import com.chainsys.crs.services.RegisterServices;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String phoneno = request.getParameter("phoneno");
		LocalDate dob = LocalDate.parse(request.getParameter("dob"));
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		User user = new User();
		user.setName(name);
		user.setPhoneno(phoneno);
		user.setDob(dob);
		user.setEmail(email);
		user.setPassword(password);
		user.setCreated_by(name);
		user.setCreated_date(LocalDate.now());
		user.setModified_by(name);
		user.setModified_date(LocalDate.now());
		RegisterServices regServices = new RegisterServices();
		try {
			int rows = regServices.addUser(user);
			if (rows > 0) {
				request.setAttribute("msg", "Inserted Successfully");
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("register.jsp");
				requestdispatcher.forward(request, response);
			}
		} catch (CourseMangnmtException e) {
			String result =e.getMessage();
			request.setAttribute("msg",result);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("register.jsp");
			requestdispatcher.forward(request, response);
		}
	}
}
