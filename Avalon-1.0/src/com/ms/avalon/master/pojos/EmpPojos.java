package com.ms.avalon.master.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="empmaster")

public class EmpPojos 
{
@Id
@GeneratedValue

@Column(name="EmpId")
private int empId;
public int getEmpId() {
	return empId;
}

public void setEmpId(int empId) {
	this.empId = empId;
}

public String getEmpCode() {
	return empCode;
}

public void setEmpCode(String empCode)
{
	this.empCode = empCode;
}

public String getEmpPin() 
{
	return empPin;
}

public void setEmpPin(String empPin) {
	this.empPin = empPin;
}

public int getDepartId() {
	return departId;
}

public void setDepartId(int departId) {
	this.departId = departId;
}

public int getLocationId() {
	return locationId;
}

public void setLocationId(int locationId) {
	this.locationId = locationId;
}

public int getManagerId() {
	return managerId;
}

public void setManagerId(int managerId) {
	this.managerId = managerId;
}

public String getfName() {
	return fName;
}

public void setfName(String fName) {
	this.fName = fName;
}

public String getlName() {
	return lName;
}

public void setlName(String lName) {
	this.lName = lName;
}

public String getdOB() {
	return dOB;
}

public void setdOB(String dOB) {
	this.dOB = dOB;
}

public String getdOJ() {
	return dOJ;
}

public void setdOJ(String dOJ) {
	this.dOJ = dOJ;
}

public String getMobile() {
	return mobile;
}

public void setMobile(String mobile) {
	this.mobile = mobile;
}

public String getAltMobile() {
	return altMobile;
}

public void setAltMobile(String altMobile) {
	this.altMobile = altMobile;
}

public String getEmrgNo() {
	return emrgNo;
}

public void setEmrgNo(String emrgNo) {
	this.emrgNo = emrgNo;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getAltEmail() {
	return altEmail;
}

public void setAltEmail(String altEmail) {
	this.altEmail = altEmail;
}

public String getDesignation() {
	return designation;
}

public void setDesignation(String designation) {
	this.designation = designation;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public String getPanNo() {
	return panNo;
}

public void setPanNo(String panNo) {
	this.panNo = panNo;
}

public String getPassPortNo() {
	return passPortNo;
}

public void setPassPortNo(String passPortNo) {
	this.passPortNo = passPortNo;
}

public String getpAddress() {
	return pAddress;
}

public void setpAddress(String pAddress) {
	this.pAddress = pAddress;
}

public String getpCity() {
	return pCity;
}

public void setpCity(String pCity) {
	this.pCity = pCity;
}

public String getpState() {
	return pState;
}

public void setpState(String pState) {
	this.pState = pState;
}

public int getpPin() {
	return pPin;
}

public void setpPin(int pPin) {
	this.pPin = pPin;
}

public String getcAddress() {
	return cAddress;
}

public void setcAddress(String cAddress) {
	this.cAddress = cAddress;
}

public String getcCity() {
	return cCity;
}

public void setcCity(String cCity) {
	this.cCity = cCity;
}


public String getcCountry() {
	return cCountry;
}

public void setcCountry(String cCountry) {
	this.cCountry = cCountry;
}


public String getCreatedBy() {
	return createdBy;
}

public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
}

public String getProfilePic() {
	return profilePic;
}

public void setProfilePic(String profilePic) {
	this.profilePic = profilePic;
}

public String getSignature() {
	return signature;
}

public void setSignature(String signature) {
	this.signature = signature;
}

public String getUpdatedBy() {
	return updatedBy;
}

public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
}

public String getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
}

public String getUpdatedDate() {
	return updatedDate;
}

public void setUpdatedDate(String updatedDate) {
	this.updatedDate = updatedDate;
}

@Column(name="EmpCode")
private String empCode;

@Column(name="EmpPin")
private String empPin;

@Column(name="DepartId")
private int departId;

@Column(name="LocationId")
private int locationId;

@Column(name="ManagerId")
private int managerId;
	
@Column(name="FName")
private String fName;

@Column(name="LName")
private String lName;

@Column(name="DOB")
private String dOB;

@Column(name="DOJ")
private String dOJ;

@Column(name="Mobile")
private String mobile;

@Column(name="AltMobile")
private String altMobile;

@Column(name="EmrgNo")
private String emrgNo;

@Column(name="Email")
private String email;

@Column(name="AltEmail")
private String altEmail;

@Column(name="Designation")
private String designation;

@Column(name="Status")
private String status;

@Column(name="Gender")
private String gender;

@Column(name="PanNo")
private String panNo;

@Column(name="PassPortNo")
private String passPortNo;

@Column(name="PAddress")
private String pAddress;

@Column(name="PCity")
private String pCity;

@Column(name="PState")
private String pState;

@Column(name="PPin")
private int pPin;

@Column(name="CAddress")
private String cAddress;

@Column(name="CCity")
private String cCity;

@Column(name="CState")
private String cState;

public String getcState() {
	return cState;
}

public void setcState(String cState) {
	this.cState = cState;
}

@Column(name="CCountry")
private String cCountry;

@Column(name="CPin")
private int cPin;

public int getcPin() {
	return cPin;
}

public void setcPin(int cPin) {
	this.cPin = cPin;
}

@Column(name="CreatedBy")
private String createdBy;

@Column(name="ProfilePic")
private String profilePic;

@Column(name="Signature")
private String signature;

@Column(name="UpdatedBy")
private String updatedBy;

@Column(name="CreatedDate")
private String createdDate;

@Column(name="UpdatedDate")
private String updatedDate;

}
