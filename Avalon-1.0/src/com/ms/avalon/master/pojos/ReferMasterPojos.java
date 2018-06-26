package com.ms.avalon.master.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="refermaster")

public class ReferMasterPojos
{
@Id
@GeneratedValue

@Column(name="RefId")
private int refId;

public int getRefId() {
	return refId;
}

public void setRefId(int refId) {
	this.refId = refId;
}

public String getRefName() {
	return refName;
}

public void setRefName(String refName) {
	this.refName = refName;
}

@Column(name="RefName")
private String refName;

}