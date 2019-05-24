package com.chainsys.crs.services;

import com.chainsys.crs.dao.CourseEnrollmentDAO;
import com.chainsys.crs.dao.RegisterDAO;
import com.chainsys.crs.exception.RegistrationException;
import com.chainsys.crs.model.User;

public class RegisterServices {
	public int addUser(User user) throws RegistrationException {
		RegisterDAO regDAO = new RegisterDAO();
		int rows = 0;
		try {
			rows = regDAO.addUser(user);
		} catch (Exception e) {
			throw new RegistrationException(e.getMessage());
		}
		return rows;
	}

	public User findUserId(User user) {
		User user1 = new User();
		CourseEnrollmentDAO courseEnrollmentDAO = new CourseEnrollmentDAO();
		try {
			user1 = courseEnrollmentDAO.findByUserId(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user1;
	}
}
