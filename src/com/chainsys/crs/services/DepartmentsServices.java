package com.chainsys.crs.services;

import java.util.ArrayList;
import java.util.List;
import com.chainsys.crs.dao.DepartmentsDAO;
import com.chainsys.crs.exception.DepartmentException;
import com.chainsys.crs.model.Department;

public class DepartmentsServices {
	public int addDepartment(Department department) throws DepartmentException {
		DepartmentsDAO departmentsDAO = new DepartmentsDAO();
		int rows = 0;
		try {
			rows = departmentsDAO.addDepartment(department);
		} catch (Exception e) {
			throw new DepartmentException(e.getMessage());

		}
		return rows;
	}

	public List<String> displayDepartments() throws Exception {
		DepartmentsDAO departmentsDAO = new DepartmentsDAO();
		List<String> departmentList = new ArrayList<String>();
		try {
			departmentList = departmentsDAO.displayDepartments();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return departmentList;
	}
}