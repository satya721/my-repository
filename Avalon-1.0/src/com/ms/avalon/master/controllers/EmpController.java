package com.ms.avalon.master.controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.connector.Request;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.ms.avalon.master.employeebeans.EmployeeBean1;
import com.ms.avalon.master.pojos.CourseMasterPojos;
import com.ms.avalon.master.pojos.DomainPojos;
import com.ms.avalon.master.pojos.EmpPojos;
import com.ms.avalon.master.pojos.FreshEnquiryPojos;
import com.ms.avalon.master.service.EmpService;
import com.ms.avalon.master.service.EmpService1;

@Controller
public class EmpController
{
	@Autowired
	EmpService1 empser1,empser2;
@RequestMapping(value="/emplogin")
public  @ResponseBody String login(String empCode,int empPin)
{
	System.out.println("name :"+empCode+" id:"+empPin);
	
	boolean bi=empser1.login1(empCode, empPin);
	  //System.out.println(bi);
	  
	if(bi)
	  return "Success";
	else
		return "fail";
}

@RequestMapping(value="/Layout")
   public String openLayout(Model map )
{
 List<EmpPojos> li= empser1.getEmployees();
 map.addAttribute("emp",li);
 for(EmpPojos ep:li)
 {
	 
	// System.out.println(ep.getfName());
  
 }

 List<DomainPojos> di=  empser1.getDomain();
 map.addAttribute("empdo",di);
 for(DomainPojos ep:di)
 {
	 
	 System.out.println(ep.getDomainName());
  
 }
  
 List<Integer> mi=empser1.getManager();
   map.addAttribute("empma",mi);
 for(Integer ep:mi)
 {
	 
	 System.out.println(ep.intValue());
  
 }

 
 List<DomainPojos> list1=empser1.getDomainNane(); 
 for(DomainPojos li5:list1)
 {
	 
	 
 }
 
 return "Layout";

}
@RequestMapping(value="/getDetail")
public String getEmployeeDetail(Integer Id,Model map)
{
 EmpPojos ep=empser1.getDetailEmployes(Id);
// System.out.println(ep.getDesignation());
  map.addAttribute("em",ep);
      return "EmpDetail";
}
@RequestMapping(value="/searchByKeyword")
public String searchKey(String serkey,Model map)
{
	List<EmpPojos> l=empser1.searchKey(serkey);

    for(EmpPojos ep:l)
	 { 
		 System.out.println(ep.getfName());
	  
	 }
	 map.addAttribute("emd",l);
     if(l.size()==0)
    	 return "error";
     else
	 return "SearchEmp";
	
}

@RequestMapping(value="/setDetail")
public @ResponseBody String  registration(EmployeeBean1 empb)
{
	boolean  bi=empser1.setDetail(empb);
if(bi)
return "success";
else
	return "error";

}

@RequestMapping(value="/Register")
public String reg()
{
	return "Registration";
}

@RequestMapping(value="/OpenUpdateEmp")
public  String OpenUpdateEmployees(Integer VI, Model map)
{
	System.out.println("empcontroller"+VI);
   EmpPojos pj1= empser2.getDetailEmployes(VI);
   System.out.println(pj1.getfName());
   System.out.println(pj1.getlName());
   
   map.addAttribute("em",pj1); 
    return "EmpUpdate";

}
@RequestMapping(value="/UpdateEmployee")
public @ResponseBody String  UpdateEmployees(EmployeeBean1 empb)
{
boolean bi=empser1.update(empb);	

if(bi)
return "success";
else
return "error";

}
 
@RequestMapping(value="/getCourse")
public  @ResponseBody String getCourse(Integer domainId,Model map)
{
 System.out.println(domainId);
	List<CourseMasterPojos> l=empser1.searchCourse(domainId);
StringBuilder sb=new StringBuilder();
    for(CourseMasterPojos cm:l)
	 { 
		 sb.append("<option>"+cm.getCourseName()+"</option>");
	  
	 }
	 
     	return sb.toString();
	
}

@RequestMapping(value="/SearchByDate")
public  @ResponseBody String SearchByDate(String From,String To,Model map)
{
	System.out.println(From);
	System.out.println(To);
	List<String> li=empser1.searchByDateEmp(From,To);
	StringBuilder sb=new StringBuilder();
    for(String cm:li)
	 { 
		 sb.append("<option>"+cm+"</option>");
	  
	 }
	 
     	return sb.toString();
}

@RequestMapping(value="/SearchByTable")
public  @ResponseBody String searchByTable(String tabnam,String sernam) 
{
	
	System.out.println(tabnam+" "+sernam);
 List<String> li=empser1.getEmpByTable(tabnam,sernam);
for(String ep:li)
{ 
	 System.out.println(ep);
 
}

StringBuilder sb=new StringBuilder();
for(String cm:li)
 { 
	 sb.append("<option>"+cm+"</option>");
  
 }
 
 	return sb.toString();
}

@RequestMapping(value="/fileupload")
public @ResponseBody String fileupload ( @RequestParam MultipartFile file) throws Exception
{
	System.out.println("empcontroller");
	FreshEnquiryPojos fsp;
	List<FreshEnquiryPojos> li=new ArrayList<FreshEnquiryPojos>();
	
      XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
      System.out.println("fsfddsf");
      XSSFSheet sheet = workbook.getSheetAt(0);
    int i=1;
    while(i<sheet.getLastRowNum())
    {
    	fsp=new FreshEnquiryPojos();
    	XSSFRow row=sheet.getRow(i++);
    	fsp.setName(row.getCell(0).getStringCellValue());
    	fsp.setMobile(row.getCell(1).getNumericCellValue());
    	fsp.setCollege(row.getCell(2).getStringCellValue());
    	fsp.setPassOutYear((int)row.getCell(3).getNumericCellValue());
    	
    	li.add(fsp);
    }
      workbook.close();

 boolean  b=empser1.fileupload(li);
 if(b)
 {
return "success";	

}
 else {
	 
 return "error";
 }
 }

@RequestMapping(value="/FileImageUpload")
public @ResponseBody String fileImageUpload(@RequestParam(value="myArray[]") String[] Url,@RequestParam(value="myArray1[]") String[] Name)
{
	
	
boolean b=	empser1.fileImageUpload(Name,Url);	
	
	 if(b)
	 {
	return "success";	

	}
	 else {
		 
	 return "error";
	 }

}

}
