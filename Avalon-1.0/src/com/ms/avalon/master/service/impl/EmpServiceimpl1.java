package com.ms.avalon.master.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.ms.avalon.master.dao.EmpDao1;
import com.ms.avalon.master.employeebeans.EmployeeBean1;
import com.ms.avalon.master.pojos.CourseMasterPojos;
import com.ms.avalon.master.pojos.DocumentMasterPojos;
import com.ms.avalon.master.pojos.DomainPojos;
import com.ms.avalon.master.pojos.EmpPojos;
import com.ms.avalon.master.pojos.FreshEnquiryPojos;
import com.ms.avalon.master.service.EmpService1;

public class EmpServiceimpl1 implements EmpService1
{
	@Autowired
	EmpDao1 empDao1;
	
	FreshEnquiryPojos fsp;
	

	public boolean login1(String empCode,int empPin) 
	{
		
	  return empDao1.check(empCode,empPin);
	}

	@Override
	public List<EmpPojos> getEmployees() 
	{
		return empDao1.getEmployeesData();
		
	}

	@Override
	public EmpPojos getDetailEmployes(Integer empId)
	{
		
		return empDao1.getEmploysData(empId);
	}

	@Override
	public List<EmpPojos> searchKey(String serkey)
	{
		
		return empDao1.getSearch(serkey);
	}

	@Override
	public boolean setDetail(EmployeeBean1 empb)
	{
		
		EmpPojos emppojos=new EmpPojos();
		emppojos.setfName(empb.getEmpfname());
		emppojos.setlName(empb.getEmplname());
		
		emppojos.setEmail(empb.getEmpmail());
		emppojos.setMobile(empb.getEmpmobile());
		emppojos.setpState(empb.getEmpstate());
		emppojos.setpAddress(empb.getEmpadd());
		emppojos.setDesignation(empb.getEmpdeg());
		emppojos.setDepartId(empb.getEmpdepart());
		return empDao1.setDetaildao(emppojos);
	}

	@Override
	public boolean update(EmployeeBean1 empb) 
	{
	
		EmpPojos emppojos=new EmpPojos();
		emppojos.setEmpId(empb.getEmpid());
		emppojos.setfName(empb.getEmpfname());
		emppojos.setlName(empb.getEmplname());
		
		emppojos.setEmail(empb.getEmpmail());
		emppojos.setMobile(empb.getEmpmobile());
		emppojos.setcState(empb.getEmpstate());
		emppojos.setcAddress(empb.getEmpadd());
		emppojos.setDesignation(empb.getEmpdeg());
		emppojos.setDepartId(empb.getEmpdepart());
		return empDao1.setUpdateDao(emppojos);
	
		}

	@Override
	public List<DomainPojos> getDomain()
	
	
	{
		
		return empDao1.getDomainData();
	}

	@Override
	public List<CourseMasterPojos> searchCourse(Integer id)
	{
		
		return empDao1.getCourse(id);
	}

	@Override
	public List<Integer> getManager() 
	{
		
		return empDao1.getManagerData();
	}

	@Override
	public List<String> searchByDateEmp(String from, String to)
	{
		
		return empDao1.searchEmployeeByDate(from,to);
	}

	@Override
	public List<String> getEmpByTable(String tabnam, String sernam) 
	{
		return empDao1.getEmployeeByTable(tabnam,sernam);
		
	}

	@Override
	public boolean fileupload(List<FreshEnquiryPojos> li)
	{
		 return empDao1.setDetaildaoExcel(li);
}

	@Override
	public boolean fileImageUpload(String[] name, String[] url)
	{
		DocumentMasterPojos dmp;
		List<DocumentMasterPojos> li=new ArrayList<DocumentMasterPojos>();
		int i=0;
		while(i<url.length)
		{
			dmp=new DocumentMasterPojos();
	
			dmp.setUrl(url[i]);
			
			dmp.setName(name[i]);
		      li.add(dmp);
		       i++;
		}
		return empDao1.uploadImage(li);
	}

	@Override
	public List<DomainPojos> getDomainNane() 
	
	
	{
		
		return empDao1.getDomainname();
	}
	

}