package com.chainsys.crs.validator;

import com.chainsys.crs.exception.DepartmentException;
import com.chainsys.crs.exception.RegistrationException;
import com.chainsys.crs.model.Department;
import com.chainsys.crs.model.User;

public class RegisterValidator {
	public void validateRegistration(User user) throws RegistrationException {
		if (!ValidatorUtil.isValidName(user.getName())) {
			//throw new ValidationException("Invalid  name ");
			throw new RegistrationException("Invalid  name ");

			}
		if (!ValidatorUtil.isValidPassword(user.getPassword())) {
			//throw new ValidationException("No password");
			throw new RegistrationException("No password");

		}
		if (!ValidatorUtil.isValidMobileNumber(user.getPhoneno())) {
            throw new RegistrationException("invalid mobilenumber");

		}
		if (!ValidatorUtil.isValidEmail(user.getEmail())) {

			//throw new ValidationException("invalid email");
			throw new RegistrationException("invalid email");
		}

	}
	public void validateDepartment(Department department) throws DepartmentException {
		if (!ValidatorUtil.isValidName(department.getName())) {
			//throw new ValidationException("Invalid  name ");
			throw new DepartmentException("Invalid  name ");

			}

}
}
