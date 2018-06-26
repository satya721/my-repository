package com.ms.avalon.master.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="webmaster")

public class WebMasterPojos
{
@Id
@GeneratedValue

@Column(name="WebId")
private int webId;

public int getWebId() {
	return webId;
}

public void setWebId(int webId) {
	this.webId = webId;
}

public String getWebName() {
	return webName;
}

public void setWebName(String webName) {
	this.webName = webName;
}

@Column(name="WebName")
private String webName;

}