package com.ms.avalon.master.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="freshenquiry")

public class FreshEnquiryPojos 
{
@Id
@GeneratedValue
@Column(name="Id")
private int id;

@Column(name="Name")
private String name;

@Column(name="College")
private String college;

@Column(name="PassOutYear")
private int passOutYear;

@Column(name="Mobile")
private double mobile;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCollege() {
	return college;
}

public void setCollege(String college) {
	this.college = college;
}

public int getPassOutYear() {
	return passOutYear;
}

public void setPassOutYear(int d) {
	this.passOutYear = d;
}

public double getMobile() {
	return mobile;
}

public void setMobile(double d) {
	this.mobile = d;
}


}
