package com.chainsys.crs.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.chainsys.crs.exception.CourseMangnmtException;
import com.chainsys.crs.model.Materials;
import com.chainsys.crs.services.MaterialsServices;

@WebServlet("/AddVideosServlet")
public class AddVideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddVideosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String crsname = request.getParameter("courseName");
		String videos = request.getParameter("videos");
		String videodesc = request.getParameter("videodesc");
		Materials materials = new Materials();
		materials.setVideos(videos);
		materials.setName(crsname);
		materials.setVideodesc(videodesc);
		MaterialsServices materialsServices = new MaterialsServices();
		try {
			int result = materialsServices.findByCourseName(crsname);
			materials.setCourse_id(result);
			int rows = materialsServices.addVideos(materials);
			if (rows != 0) {
				request.setAttribute("msg", "success");
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("addmaterials.jsp");
				requestdispatcher.forward(request, response);
			}

		} catch (CourseMangnmtException e) {
			String result = e.getMessage();
			request.setAttribute("msg", result);
			RequestDispatcher requestdispatcher = request.getRequestDispatcher("register.jsp");
			requestdispatcher.forward(request, response);
		}

	}

}
