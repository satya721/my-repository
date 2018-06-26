package com.ms.avalon.master.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="domainmaster")

public class DomainPojos 
{
@Id
@GeneratedValue
@OneToMany(fetch=FetchType.EAGER,targetEntity=CourseMasterPojos.class,mappedBy="dom")
@Fetch(FetchMode.SUBSELECT)
@Cascade(CascadeType.ALL)
List<CourseMasterPojos> li;
@Column(name="DomainId")
private int domainId;

@Column(name="DomainName")
private String domainName;


public int getDomainId() {
	return domainId;
}



public void setDomainId(int domainId) {
	this.domainId = domainId;
}



public String getDomainName() {
	return domainName;
}



public void setDomainName(String domainName) {
	this.domainName = domainName;
}



public List<CourseMasterPojos> getLi() {
	return li;
}



public void setLi(List<CourseMasterPojos> li) {
	this.li = li;
}



}
