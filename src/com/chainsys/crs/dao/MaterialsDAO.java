package com.chainsys.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.chainsys.crs.exception.MaterialsException;
import com.chainsys.crs.model.Course;
import com.chainsys.crs.model.Materials;
import com.chainsys.crs.util.ConnectionUtil;

public class MaterialsDAO {
	static final Logger log = Logger.getLogger(MaterialsDAO.class);

	/**
	 * displayCourses is used to display courses
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<String> displayCourses() throws MaterialsException {
		List<String> courseList = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select name from  course";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Course course = new Course();
				course.setName(resultSet.getString("name"));
				courseList.add(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			throw new MaterialsException("Unable to register");

		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return courseList;
	}

	/**
	 * findByCourseName is used to find the department id from the given name
	 * 
	 * @param course
	 * @return
	 * @throws Exception
	 */
	public int findByCourseName(String name) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select course_id from course where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt("course_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return result;
	}

	/**
	 * addVideos is used to upload videos
	 * 
	 * @param materials
	 * @return
	 * @throws Exception
	 */
	public int addVideos(Materials materials) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rows = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into materials(id,videos,course_id,name,videos_desc)values(matrls_id_seq.nextval,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, materials.getVideos());
			preparedStatement.setInt(2, materials.getCourse_id());
			preparedStatement.setString(3, materials.getName());
			preparedStatement.setString(4, materials.getVideodesc());
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return rows;
	}

	/**
	 * displayVideos is used to display videos for the particular course
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Materials> displayVideos() throws Exception {
		List<Materials> videoList = new ArrayList<Materials>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select name,videos from  materials";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Materials materials = new Materials();
				materials.setName(resultSet.getString("name"));
				materials.setVideos(resultSet.getString("videos"));
				videoList.add(materials);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return videoList;
	}

	public List<Materials> displayParticularVideos(String coursename) throws Exception {
		List<Materials> videoList = new ArrayList<Materials>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Materials materials = new Materials();
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select videos from  materials where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, coursename);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				materials = new Materials();
				materials.setVideos(resultSet.getString("videos"));
				videoList.add(materials);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return videoList;
	}

}
