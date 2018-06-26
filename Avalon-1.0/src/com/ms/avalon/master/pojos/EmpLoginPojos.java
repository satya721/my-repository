package com.ms.avalon.master.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emploginmaster")

public class EmpLoginPojos 
{
@Id
@GeneratedValue

@Column(name="LoginId")
private int loginId;
	
public int getLoginId() {
	return loginId;
}

public void setLoginId(int loginId) {
	this.loginId = loginId;
}

public int getPin() {
	return pin;
}

public void setPin(int pin) {
	this.pin = pin;
}

public String getEmpCode() {
	return empCode;
}

public void setEmpCode(String empCode) {
	this.empCode = empCode;
}

@Column(name="Pin")
private int pin;
	
@Column(name="EmpCode")
private String empCode;
	
}
