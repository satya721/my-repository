package com.ms.avalon.master.employeebeans;

public class EmployeeBean1
{
    private int empid;
     private String empfname;
 	private String emplname;
	private String empmobile;
	private String empmail;
	private String empadd;
	private String  empdeg;
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpdeg() {
		return empdeg;
	}
	public void setEmpdeg(String empdeg) {
		this.empdeg = empdeg;
	}
	public Integer getEmpdepart() {
		return empdepart;
	}
	public void setEmpdepart(Integer empdepart) {
		this.empdepart = empdepart;
	}
	private Integer empdepart;
	private String empstate;
	public String getEmpfname()
	{
		return empfname;
	}
	public void setEmpfname(String empfname) {
		this.empfname = empfname;
	}
	public String getEmplname() {
		return emplname;
	}
	public void setEmplname(String emplname) {
		this.emplname = emplname;
	}
	public String getEmpmobile() {
		return empmobile;
	}
	public void setEmpmobile(String empmobile) {
		this.empmobile = empmobile;
	}
	public String getEmpmail() {
		return empmail;
	}
	public void setEmpmail(String empmail) {
		this.empmail = empmail;
	}
	public String getEmpadd() {
		return empadd;
	}
	public void setEmpadd(String empadd) {
		this.empadd = empadd;
	}
	public String getEmpstate() {
		return empstate;
	}
	public void setEmpstate(String empstate) {
		this.empstate = empstate;
	}


}
