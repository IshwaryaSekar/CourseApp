package com.chainsys.crs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.chainsys.crs.exception.CourseException;
import com.chainsys.crs.model.Author;
import com.chainsys.crs.model.Course;
import com.chainsys.crs.model.Department;
import com.chainsys.crs.util.ConnectionUtil;

public class CoursesDAO {
	static final Logger log = Logger.getLogger(CoursesDAO.class);

	/**
	 * findByDepartmentName is used to find the department id
	 * 
	 * @param department
	 * @return
	 * @throws Exception
	 */
	public int findByDepartmentName(Department department) throws CourseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select id from department where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, department.getName());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result = resultSet.getInt("id");
				log.debug(result);
			}
		} catch (SQLException e) {
			throw new CourseException("Unable to add course");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return result;
	}

	/**
	 * findByAuthorName is used to find the author id
	 * 
	 * @param author
	 * @return
	 * @throws Exception
	 */
	public int findByAuthorName(Author author) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int result1 = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select author_id from author where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, author.getName());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				result1 = resultSet.getInt("author_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return result1;
	}

	/**
	 * addCourse is used to add the course details
	 * 
	 * @param course
	 * @return
	 * @throws Exception
	 */
	public int addCourse(Course course) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int rows = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into course(course_id,name,start_date,end_date,department_id,course_author_id,where_you_will_learn,requirements)values(course_id_seq.nextVal,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, course.getName());
			preparedStatement.setDate(2, Date.valueOf(course.getStartDate()));
			preparedStatement.setDate(3, Date.valueOf(course.getEndDate()));
			preparedStatement.setInt(4, course.getDepartment_id());
			preparedStatement.setInt(5, course.getCourse_author_id());
			preparedStatement.setString(6, course.getWhere_you_will_learn());
			preparedStatement.setString(7, course.getRequirements());
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return rows;
	}

	/**
	 * displayCourses is display the course name
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<String> displayCourses() throws Exception {
		List<String> courseNameList = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select name from course";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Course course = new Course();
				course.setName(resultSet.getString("name"));
				courseNameList.add(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return courseNameList;
	}

	/**
	 *  displayUserCourses is used to display the course name with the appropriate department id
	 * @param deptname
	 * @return
	 */
	public List<String> displayUserCourses(String deptname) {
		List<String> courseNameList = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select name from course where department_id = "
					+ "(select id from department where name = ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, deptname);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Course course = new Course();
				course.setName(resultSet.getString("name"));
				courseNameList.add(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return courseNameList;
	}

	/**
	 * displayCourseDesc  is used to display the  course description with course  name
	 * @param coursename
	 * @return
	 */
	public List<Course> displayCourseDesc(String coursename) {
		List<Course> courseDesc = new ArrayList<Course>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select name,where_you_will_learn, requirements from course where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, coursename);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Course course = new Course();
				course.setName(resultSet.getString("name"));
				course.setWhere_you_will_learn(resultSet.getString("where_you_will_learn"));
				course.setRequirements(resultSet.getString("requirements"));
				courseDesc.add(course);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return courseDesc;
	}
}
