package com.chainsys.crs.model;

import java.time.LocalDate;

public class Course {
	private String name;
	private int course_id;
	private int department_id;
	private int course_author_id;
	private String image;
	private LocalDate startDate;
	private LocalDate endDate;
	private Department department;
	private Author author;
	private int img_id;
	private String where_you_will_learn;
	private String requirements;

	public String getWhere_you_will_learn() {
		return where_you_will_learn;
	}

	public void setWhere_you_will_learn(String where_you_will_learn) {
		this.where_you_will_learn = where_you_will_learn;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public int getCourse_author_id() {
		return course_author_id;
	}

	public void setCourse_author_id(int course_author_id) {
		this.course_author_id = course_author_id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public int getImg_id() {
		return img_id;
	}

	public void setImg_id(int img_id) {
		this.img_id = img_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + course_author_id;
		result = prime * result + course_id;
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + department_id;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((image == null) ? 0 : image.hashCode());
		result = prime * result + img_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((requirements == null) ? 0 : requirements.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((where_you_will_learn == null) ? 0 : where_you_will_learn.hashCode());
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
		Course other = (Course) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (course_author_id != other.course_author_id)
			return false;
		if (course_id != other.course_id)
			return false;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (department_id != other.department_id)
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (img_id != other.img_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (requirements == null) {
			if (other.requirements != null)
				return false;
		} else if (!requirements.equals(other.requirements))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (where_you_will_learn == null) {
			if (other.where_you_will_learn != null)
				return false;
		} else if (!where_you_will_learn.equals(other.where_you_will_learn))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", course_id=" + course_id + ", department_id=" + department_id
				+ ", course_author_id=" + course_author_id + ", image=" + image + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", department=" + department + ", author=" + author + ", img_id=" + img_id
				+ ", what_you_will_learn=" + where_you_will_learn + ", requirements=" + requirements
				+ ", getWhat_you_will_learn()=" + getWhere_you_will_learn() + ", getRequirements()=" + getRequirements()
				+ ", getName()=" + getName() + ", getCourse_id()=" + getCourse_id() + ", getDepartment_id()="
				+ getDepartment_id() + ", getCourse_author_id()=" + getCourse_author_id() + ", getImage()=" + getImage()
				+ ", getStartDate()=" + getStartDate() + ", getEndDate()=" + getEndDate() + ", getDepartment()="
				+ getDepartment() + ", getAuthor()=" + getAuthor() + ", getImg_id()=" + getImg_id() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}

}
