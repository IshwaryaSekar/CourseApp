package com.chainsys.crs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.crs.validator.LoginValidator;

@WebServlet("/AuthorLoginServlet")
public class AuthorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AuthorLoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (LoginValidator.checkUser(username, password)) {
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("authorpage.jsp");
			requestdispatcher.forward(request, response);
		} else {
			request.setAttribute("ERROR", "Invalid username or password ");
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("authorlogin.jsp");
			requestdispatcher.forward(request, response);
		}

	}
}
