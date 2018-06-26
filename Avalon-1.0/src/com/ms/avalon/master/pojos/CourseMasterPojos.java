package com.ms.avalon.master.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coursemaster")

public class CourseMasterPojos 
{
@Id
@GeneratedValue

@Column(name="CourseId")
private int courseId;

@Column(name="DomainId")
private int domainId;

@Column(name="CourseName")
private String courseName;
public int getCourseId() {
	return courseId;
}
public void setCourseId(int courseId) {
	this.courseId = courseId;
}

public int getDomainId() {
	return domainId;
}

public void setDomainId(int domainId) {
	this.domainId = domainId;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}



}