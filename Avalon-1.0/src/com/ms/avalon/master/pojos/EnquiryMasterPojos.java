package com.ms.avalon.master.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="enquirymaster")

public class EnquiryMasterPojos
{
@Id
@GeneratedValue

@Column(name="EnqId")
private int enqId;

public int getEnqId() {
	return enqId;
}

public void setEnqId(int enqId) {
	this.enqId = enqId;
}

public String getEnqName() {
	return enqName;
}

public void setEnqName(String enqName) {
	this.enqName = enqName;
}

@Column(name="EnqName")
private String enqName;

}