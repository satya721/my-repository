package com.ms.avalon.master.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ms.avalon.master.employeebeans.EmployeeBean1;
import com.ms.avalon.master.pojos.CourseMasterPojos;
import com.ms.avalon.master.pojos.DomainPojos;
import com.ms.avalon.master.pojos.EmpPojos;
import com.ms.avalon.master.pojos.FreshEnquiryPojos;

public interface EmpService1 
{

	boolean login1(String empCode,int empPin);

	List<EmpPojos> getEmployees();

	EmpPojos getDetailEmployes(Integer empId);

	List<EmpPojos> searchKey(String serkey);

	boolean setDetail(EmployeeBean1 empb);

     boolean update(EmployeeBean1 empb);

	List<DomainPojos> getDomain();

	List<CourseMasterPojos> searchCourse(Integer id);

	List<Integer> getManager();

	List<String> searchByDateEmp(String from, String to);

	 List<String> getEmpByTable(String tabnam, String sernam);

	boolean fileupload(List<FreshEnquiryPojos>li) ;

    boolean fileImageUpload(String[] name, String[] url);

	List<DomainPojos> getDomainNane();



	
}
