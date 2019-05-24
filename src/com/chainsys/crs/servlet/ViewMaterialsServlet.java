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
import javax.servlet.http.HttpSession;

import com.chainsys.crs.model.Materials;
import com.chainsys.crs.services.MaterialsServices;

@WebServlet("/ViewMaterialsServlet")
public class ViewMaterialsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewMaterialsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String coursename = request.getParameter("coursename");
		HttpSession session = request.getSession(false);
		session.getAttribute("name");
		System.out.println("called");
		MaterialsServices materialsServices = new MaterialsServices();
		try {
			List<Materials> videoList = new ArrayList<Materials>();
			videoList = materialsServices.displayParticularVideos(coursename);
			if (!videoList.isEmpty()) {
				request.setAttribute("VIDEOS", videoList);
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("listofvideos.jsp");
				requestdispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
