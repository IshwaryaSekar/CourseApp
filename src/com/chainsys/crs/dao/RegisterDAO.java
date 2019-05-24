package com.chainsys.crs.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;


import com.chainsys.crs.exception.CourseMangnmtException;
import com.chainsys.crs.exception.RegistrationException;
import com.chainsys.crs.model.User;
import com.chainsys.crs.util.ConnectionUtil;

public class RegisterDAO {
	static final Logger log = Logger.getLogger(RegisterDAO.class);

	/**
	 * addUser is used to add the user details
	 * 
	 * @param user
	 * @return
	 * @throws CourseMangnmtException
	 */
	public int addUser(User user) throws RegistrationException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rows = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into course_user (user_id,name,phoneno,dob,email,password,created_by,created_date,modified_by,modified_date)"
					+ " values (course_user_id_seq.nextVal,?,?,?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getPhoneno());
			preparedStatement.setDate(3, Date.valueOf(user.getDob()));
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.setString(6, user.getCreated_by());
			preparedStatement.setDate(7, Date.valueOf(user.getCreated_date()));
			preparedStatement.setString(8, user.getModified_by());
			preparedStatement.setDate(9, Date.valueOf(user.getModified_date()));
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
		         throw new RegistrationException("Unable to register");
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return rows;
	}
}
