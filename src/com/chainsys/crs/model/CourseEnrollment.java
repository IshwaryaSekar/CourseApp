package com.chainsys.crs.model;

public class CourseEnrollment {
	private int enroll_id;
	private User user;
	private Course course;
	private int enroll_user_id;
   private int enroll_course_id;
public int getEnroll_id() {
	return enroll_id;
}
public void setEnroll_id(int enroll_id) {
	this.enroll_id = enroll_id;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public int getEnroll_user_id() {
	return enroll_user_id;
}
public void setEnroll_user_id(int enroll_user_id) {
	this.enroll_user_id = enroll_user_id;
}
public int getEnroll_course_id() {
	return enroll_course_id;
}
public void setEnroll_course_id(int enroll_course_id) {
	this.enroll_course_id = enroll_course_id;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((course == null) ? 0 : course.hashCode());
	result = prime * result + enroll_course_id;
	result = prime * result + enroll_id;
	result = prime * result + enroll_user_id;
	result = prime * result + ((user == null) ? 0 : user.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CourseEnrollment other = (CourseEnrollment) obj;
	if (course == null) {
		if (other.course != null)
			return false;
	} else if (!course.equals(other.course))
		return false;
	if (enroll_course_id != other.enroll_course_id)
		return false;
	if (enroll_id != other.enroll_id)
		return false;
	if (enroll_user_id != other.enroll_user_id)
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	return true;
}
@Override
public String toString() {
	return "CourseEnrollment [enroll_id=" + enroll_id + ", user=" + user + ", course=" + course + ", enroll_user_id="
			+ enroll_user_id + ", enroll_course_id=" + enroll_course_id + ", getEnroll_id()=" + getEnroll_id()
			+ ", getUser()=" + getUser() + ", getCourse()=" + getCourse() + ", getEnroll_user_id()="
			+ getEnroll_user_id() + ", getEnroll_course_id()=" + getEnroll_course_id() + ", hashCode()=" + hashCode()
			+ ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
} 
	}
