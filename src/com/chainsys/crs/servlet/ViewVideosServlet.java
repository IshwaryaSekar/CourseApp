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
import com.chainsys.crs.model.Materials;
import com.chainsys.crs.services.MaterialsServices;

@WebServlet("/ViewVideosServlet")
public class ViewVideosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewVideosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("called");
		MaterialsServices materialsServices = new MaterialsServices();
		try {
			List<Materials> videoList = new ArrayList<Materials>();
			videoList = materialsServices.displayVideos();
			{
				if (!videoList.isEmpty())
					request.setAttribute("VIDEOS", videoList);
				RequestDispatcher requestdispatcher = request.getRequestDispatcher("viewvideos.jsp");
				requestdispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
