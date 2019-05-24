package com.chainsys.crs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import com.chainsys.crs.exception.DepartmentException;
import com.chainsys.crs.model.Department;
import com.chainsys.crs.util.ConnectionUtil;

public class DepartmentsDAO {
	static final Logger log = Logger.getLogger(DepartmentsDAO.class);

	/**
	 * displayDepartments is used to display departments
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<String> displayDepartments() throws DepartmentException {
		List<String> departmentList = new ArrayList<String>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "select name from  department";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Department department = new Department();
				department.setName(resultSet.getString("name"));
				departmentList.add(resultSet.getString("name"));
			}
		} catch (SQLException e) {
			throw new DepartmentException("Unable to add department");

		} finally {
			ConnectionUtil.close(connection, preparedStatement, resultSet);
		}
		return departmentList;
	}

	/**
	 * addDepartment is used to add the department
	 * 
	 * @param department
	 * @return
	 * @throws Exception
	 */
	public int addDepartment(Department department) throws Exception {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int rows = 0;
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "insert into department (id,name) values (dpmt_id_seq.nextval,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, department.getName());
			rows = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.close(connection, preparedStatement, null);
		}
		return rows;
	}
}
