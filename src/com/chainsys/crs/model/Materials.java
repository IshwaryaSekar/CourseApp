package com.chainsys.crs.model;

public class Materials {
	private int course_id;
	private String videos;
	private Course course;
	private String name;
	private String videodesc;
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getVideos() {
		return videos;
	}
	public void setVideos(String videos) {
		this.videos = videos;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVideodesc() {
		return videodesc;
	}
	public void setVideodesc(String videodesc) {
		this.videodesc = videodesc;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + course_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((videodesc == null) ? 0 : videodesc.hashCode());
		result = prime * result + ((videos == null) ? 0 : videos.hashCode());
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
		Materials other = (Materials) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (course_id != other.course_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (videodesc == null) {
			if (other.videodesc != null)
				return false;
		} else if (!videodesc.equals(other.videodesc))
			return false;
		if (videos == null) {
			if (other.videos != null)
				return false;
		} else if (!videos.equals(other.videos))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Materials [course_id=" + course_id + ", videos=" + videos + ", course=" + course + ", name=" + name
				+ ", videodesc=" + videodesc + ", getCourse_id()=" + getCourse_id() + ", getVideos()=" + getVideos()
				+ ", getCourse()=" + getCourse() + ", getName()=" + getName() + ", getVideodesc()=" + getVideodesc()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

	}
