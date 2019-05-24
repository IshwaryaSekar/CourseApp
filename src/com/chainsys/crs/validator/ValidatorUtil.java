package com.chainsys.crs.validator;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidatorUtil {
	public static boolean isValidName(String input) {
		return input != null && !input.trim().equals("") && input.matches("^[a-zA-Z- ]{4,100}");
	}

	public static boolean isValidPassword(String input) {
		return input != null && !input.trim().equals("");
	}

	public static boolean isValidMobileNumber(String mobilenumber) {
		Pattern pattern = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		Matcher matcher = pattern.matcher(mobilenumber);
		return (matcher.find() && matcher.group().equals(mobilenumber));
	}

	public static boolean isValidEmail(String input) {
		return input.indexOf('@') != -1 && input.indexOf('.') != -1;
	}

}
