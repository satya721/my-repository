package com.ms.avalon.master.dao;

import java.util.List;

import com.ms.avalon.master.pojos.CourseMasterPojos;
import com.ms.avalon.master.pojos.DocumentMasterPojos;
import com.ms.avalon.master.pojos.DomainPojos;
import com.ms.avalon.master.pojos.EmpPojos;
import com.ms.avalon.master.pojos.FreshEnquiryPojos;

public interface EmpDao1 {

	boolean check(String empCode,int empPin);

List<EmpPojos> getEmployeesData();

EmpPojos getEmploysData(Integer empId);

List<EmpPojos> getSearch(String serkey);

boolean setDetaildao(EmpPojos emppojos);

boolean setUpdateDao(EmpPojos emppojos);

List<DomainPojos> getDomainData();

List<CourseMasterPojos> getCourse(Integer id);

List<Integer> getManagerData();

List<String> searchEmployeeByDate(String from, String to);

List<String> getEmployeeByTable(String tabnam, String sernam);

boolean setDetaildaoExcel(List<FreshEnquiryPojos> li);

boolean uploadImage(List<DocumentMasterPojos> li);

List<DomainPojos> getDomainname();

}
