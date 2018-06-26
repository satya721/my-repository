package com.ms.avalon.master.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stdregmaster")

public class StdRegMasterPojos
{
@Id
@GeneratedValue

@Column(name="StdRegId")
private int stdRegId;

public int getStdRegId() {
	return stdRegId;
}

public void setStdRegId(int stdRegId) {
	this.stdRegId = stdRegId;
}

public String getStdRegName() {
	return stdRegName;
}

public void setStdRegName(String stdRegName) {
	this.stdRegName = stdRegName;
}

@Column(name="StdRegName")
private String stdRegName;

}