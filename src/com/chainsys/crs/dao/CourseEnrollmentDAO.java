package com.chainsys.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.chainsys.crs.model.Course;
import com.chainsys.crs.model.User;
import com.chainsys.crs.util.ConnectionUtil;

public class CourseEnrollmentDAO {
	static final Logger log = Logger.getLogger(CourseEnrollmentDAO.class);

	/**
	 * addStudentEnrollment is used to transaction list of the student
	 * @param course
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int addStudentEnrollment(Course course, User user) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rows = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into course_enrollment(enroll_id,enroll_course_id,enroll_user_id) values (enroll_id_seq.nextval,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, course.getCourse_id());
			preparedStatement.setInt(2, user.getUser_id());
			rows = preparedStatement.executeUpdate();
			log.debug("Query" + rows);
		} catch (SQLException e) {
			log.error("Exception caught" + e.getMessage());
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return rows;
	}

	/**
	 * findByUserId  is used to find the user id
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User findByUserId(User user) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		User user1 = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select user_id from course_user where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user1 = new User();
				user1.setUser_id(resultSet.getInt("user_id"));
				log.debug(user1.getUser_id());
			}
		} catch (SQLException e) {
			log.error("Exception Caught" + e.getMessage());
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return user1;
	}

	/**
	 * findByCourseId is used to find the course id
	 * @param course
	 * @return
	 * @throws Exception
	 */
	public Course findByCourseId(Course course) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Course course1 = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select course_id from course where name=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, course.getName());
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				course1 = new Course();
				course1.setCourse_id(resultSet.getInt("course_id"));
				log.debug(course1.getCourse_id());
			}
		} catch (SQLException e) {
			log.error("Exception Caught" + e.getMessage());
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return course1;
	}

}
