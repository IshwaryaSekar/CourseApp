package com.chainsys.crs.services;

import java.util.List;
import java.util.ArrayList;
import com.chainsys.crs.dao.MaterialsDAO;
import com.chainsys.crs.exception.MaterialsException;
import com.chainsys.crs.model.Materials;

public class MaterialsServices {
	public List<String> displayCourses() throws Exception {
		MaterialsDAO materialsdao = new MaterialsDAO();
		List<String> courseList = new ArrayList<String>();
		try {
			courseList = materialsdao.displayCourses();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseList;
	}

	public int findByCourseName(String name) {
		MaterialsDAO materialsdao = new MaterialsDAO();
		int result = 0;
		try {
			result = materialsdao.findByCourseName(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int addVideos(Materials materials) throws MaterialsException {
		MaterialsDAO materialsdao = new MaterialsDAO();
		int rows = 0;
		try {
			rows = materialsdao.addVideos(materials);
		} catch (Exception e) {
			throw new MaterialsException(e.getMessage());
		}
		return rows;
	}

	public List<Materials> displayVideos() throws Exception {
		MaterialsDAO materialsdao = new MaterialsDAO();
		List<Materials> videoList = new ArrayList<Materials>();
		try {
			videoList = materialsdao.displayVideos();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videoList;
	}

	public List<Materials> displayParticularVideos(String coursename) throws Exception {
		MaterialsDAO materialsdao = new MaterialsDAO();
		List<Materials> videoList = new ArrayList<Materials>();
		try {
			videoList = materialsdao.displayParticularVideos(coursename);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return videoList;
	}

}
